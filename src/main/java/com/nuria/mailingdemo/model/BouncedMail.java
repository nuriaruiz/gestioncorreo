package com.nuria.mailingdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BouncedMail {

    private String email;
    private long timestamp;
    @JsonProperty("smtp-id")
    private String smtpId;
    private String event;
    private String category;
    @JsonProperty("sg_event_id")
    private String sgEventId;
    @JsonProperty("sg_message_id")
    private String sgMessageId;
    private String reason;
    private String status;

    public BouncedMail() {
    }

    public BouncedMail(String email, long timestamp, String smtpId, String event, String category, String sgEventId, String sgMessageId, String reason, String status) {
        this.email = email;
        this.timestamp = timestamp;
        this.smtpId = smtpId;
        this.event = event;
        this.category = category;
        this.sgEventId = sgEventId;
        this.sgMessageId = sgMessageId;
        this.reason = reason;
        this.status = status;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public String getSmtpId() {
        return smtpId;
    }

    public void setSmtpId(String smtpId) {
        this.smtpId = smtpId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSgEventId() {
        return sgEventId;
    }

    public void setSgEventId(String sgEventId) {
        this.sgEventId = sgEventId;
    }

    public String getSgMessageId() {
        return sgMessageId;
    }

    public void setSgMessageId(String sgMessageId) {
        this.sgMessageId = sgMessageId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "BouncedMail{" +
                "email='" + email + '\'' +
                ", timestamp=" + timestamp +
                ", smtpId='" + smtpId + '\'' +
                ", event='" + event + '\'' +
                ", category='" + category + '\'' +
                ", sgEventId='" + sgEventId + '\'' +
                ", sgMessageId='" + sgMessageId + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
