package com.nuria.mailingdemo;

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridEmailService implements EmailService {

    private SendGrid sendGridClient;

    @Autowired
    public SendGridEmailService(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }
    @Override
    public void sendText(String from, String to, String subject, String body) throws IOException {
        Response response = sendEmail(from, to, subject, new Content("text/plain", body));
        System.out.println("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    @Override
    public void sendHTML(String from, String to, String subject, String body) throws IOException {
        Response response = sendEmail(from, to, subject, new Content("text/html", body));
        System.out.println("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    private Response sendEmail(String fromM, String toM, String subjectM, Content contentM) throws IOException {
        Email from   = new Email(fromM);
        String subject = subjectM;
        Email to = new Email(toM);
        Content contents = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, contentM);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = this.sendGridClient.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            return response;
        } catch (IOException ex) {
            throw ex;
        }

    }
}
