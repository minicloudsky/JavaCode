package com.model;

import java.util.Date;

public class CommentInfo {
    private int id;
    private String context = "";
    private Date createdtime;
    private String username="";
    private int blogid;

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedtime() {

        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getContext() {

        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
