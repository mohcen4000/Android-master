package com.uc2.dzprostatecare.pojo;

public class Suggestion {
    private String title;
    private String content;
    private String status;
    private int percent;


    private int idp;

    public Suggestion(String title, String content, String status, int percent,int idp) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.percent = percent;
        this.idp=idp;
    }


    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public int getPercent() {
        return percent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
