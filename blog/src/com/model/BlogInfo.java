package com.model;

import java.util.Date;

public class BlogInfo {
    private int id;
    private String title="";
    private String context="";
    private int classid;
    private String className="";
    private Date createdtime ;

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassid(int classid) {

        this.classid = classid;
    }

    public String getContext() {

        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassid() {

        return classid;
    }


}
