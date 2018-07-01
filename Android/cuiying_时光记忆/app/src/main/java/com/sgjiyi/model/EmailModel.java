package com.sgjiyi.model;

import java.util.Date;

/**
 * Created by acu on 2017/8/26.
 */

public class EmailModel {
    private Date data;
    private String title;
    private String content;
    private long countDown;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCountDown() {
        return countDown;
    }

    public void setCountDown(long countDown) {
        this.countDown = countDown;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
