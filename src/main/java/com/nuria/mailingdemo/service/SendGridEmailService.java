package com.nuria.mailingdemo.service;

import com.sendgrid.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridEmailService implements EmailService {

    private static final Log LOG = LogFactory.getLog(SendGridEmailService.class);

    private SendGrid sendGridClient;

    @Autowired
    public SendGridEmailService(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }
    @Override
    public void sendText(String from, String to, String subject, String body) throws IOException {
        Response response = sendEmail(from, to, subject, new Content("text/plain", body));
        LOG.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    @Override
    public void sendHTML(String from, String to, String subject, String body) throws IOException {
        Response response = sendEmail(from, to, subject, new Content("text/html", body));
        LOG.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    private Response sendEmail(String fromM, String toM, String subjectM, Content content) throws IOException {
        Email from   = new Email(fromM);
        String subject = subjectM;
        Email to = new Email(toM);
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = this.sendGridClient.api(request);
            LOG.info("Status code: "+ response.getStatusCode() + " Body: "
                    + response.getBody() + " Headers: " + response.getHeaders());
            return response;
        } catch (IOException ex) {
            LOG.error("Error sending mail: " + ex.getMessage());
            throw ex;
        }
    }
}
