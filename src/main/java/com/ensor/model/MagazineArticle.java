package com.ensor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class MagazineArticle implements Article {

    @Id
    @SuppressWarnings("unused")
    private String id;

    private Date entryDate;
    private User submittedBy;
    private String body;
    private String subject;

    public MagazineArticle(User submittedBy, String subject) {
        this.submittedBy = submittedBy;
        this.subject = subject;
        entryDate = new Date();
    }

    @Override
    public Date getEntryDate() {
        return entryDate;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    public User getSubmittedBy() {
        return submittedBy;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
