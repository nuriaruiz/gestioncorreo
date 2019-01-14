package com.nuria.mailingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailingdemoApplication implements CommandLineRunner {

	@Autowired
	SendGridEmailService sendGridEmailService;

	public static void main(String[] args) {
		SpringApplication.run(MailingdemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		sendGridEmailService.sendHTML("abc@gmail.com", "efg@gmail.com", "Hello World", "Hello, <strong>how are you doing?</strong>");
	}
}
