package com.nuria.mailingdemo.service;

import java.io.IOException;

public interface EmailService {
    void sendText(String from, String to, String subject, String body) throws IOException;
    void sendHTML(String from, String to, String subject, String body) throws IOException;
}
