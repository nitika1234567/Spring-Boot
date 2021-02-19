package com.example.demo.model;

import java.util.Date;
//POJO-> Plain Old Java Object
public class Post {
    private String title;
    private String body;
    private Date date;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public Date getDate() {
        return date;
    }

    public Date setDate(Date date) {
        this.date = date;
        return date;
    }


}
