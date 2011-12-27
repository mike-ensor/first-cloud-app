package com.ensor.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class BlogArticle implements Article {

    @Id
    @SuppressWarnings("unused")
    private String id;

    private Date entryDate;
    private String subject;
    private String fromSource;

    public BlogArticle(String subject, String fromSource) {
        this.subject = subject;
        this.fromSource = fromSource;
        this.entryDate = new Date();
    }

    @Override
    public Date getEntryDate() {
        return entryDate;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }
}
