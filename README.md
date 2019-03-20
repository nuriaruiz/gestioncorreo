# gestioncorreo

Configuration SendGrid in a Spring Boot project example. To test mails sending and bounced mail notifications.

In this project you could find a controller to receive SendGridNotifications: BouncesController.
And a service to send mails to SendGrid: SendGridEmailService.

To start a SendGrid project just add the dependency:

        <!-- https://mvnrepository.com/artifact/com.sendgrid/sendgrid-java -->
        <dependency>
            <groupId>com.sendgrid</groupId>
            <artifactId>sendgrid-java</artifactId>
            <version>4.3.0</version>
        </dependency>
        
 And put the API Key in properties file: spring.sendgrid.api-key=sendgridapikey
