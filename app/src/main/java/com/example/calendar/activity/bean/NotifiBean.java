package com.example.calendar.activity.bean;

import java.io.Serializable;


public class NotifiBean implements Serializable {
    private String TimeSpan;
    private String Content;
    private int Type;
    private int ArouterType;
    private String ActType;// 页面类型
    private String id;
    private String title;
    private String status;
    private String accountType;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActType() {
        return ActType;
    }

    public void setActType(String actType) {
        ActType = actType;
    }


    public int getArouterType() {
        return ArouterType;
    }

    public void setArouterType(int arouterType) {
        ArouterType = arouterType;
    }

    public void setTimeSpan(String TimeSpan) {
        this.TimeSpan = TimeSpan;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getTimeSpan() {
        return TimeSpan;
    }

    public String getContent() {
        return Content;
    }

    public int getType() {
        return Type;
    }
}
