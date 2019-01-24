package com.nuria.mailingdemo.controller;

import com.nuria.mailingdemo.model.BouncedMail;
import com.nuria.mailingdemo.service.SendGridEmailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;


@RestController
public class BouncesController {

    private static final Log LOG = LogFactory.getLog(BouncesController.class);
    @Autowired
    SendGridEmailService sendGridEmailService;

    @PostMapping("/bouncedmail")
    void newEmployee(@RequestBody BouncedMail bouncedMail) {
        try {
            // Get string date from timestamp
            Timestamp ts = new Timestamp(Long.valueOf(bouncedMail.getTimestamp()));
            sendGridEmailService.sendHTML("nuria.ruiz@gmail.com", "nuria.ruiz@gmail.com", "Bounced mail", "Hello, <strong>" + bouncedMail.getEmail() + "</strong> has been bounced. " +
                    "" + bouncedMail.getReason() + ". " + ts.toString());
        } catch (IOException e) {
            LOG.error("Error receiving bounced mail: " + e.getMessage());
        }
    }
}
