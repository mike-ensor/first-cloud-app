package com.ensor.web.model;

import com.ensor.model.Article;

import java.util.List;

public class ArticleModel {

    private List<Article> articles;
    private String subject;
    private String fromSource;
    private String type;

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromString) {
        this.fromSource = fromString;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
