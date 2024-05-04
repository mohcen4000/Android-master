package com.uc2.dzprostatecare.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Question implements Serializable {




    private int idQst;
    private String title;
    private String date;
    private String dateans;
    private String answer;
    private String status;


    public Question(int idQst,String title, String date, String dateans,String answer,String status) {
        this.idQst=idQst;
        this.title = title;
        this.date = date;
        this.dateans=dateans;
        this.status = status;
        this.answer=answer;
    }

    public String getDateans() {
        return dateans;
    }

    public void setDateans(String dateans) {
        this.dateans = dateans;
    }


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAnswer() {
        return answer;
    }

    public String getStatus() {
        return status;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdQst() {
        return idQst;
    }

    public void setIdQst(int idQst) {
        this.idQst = idQst;
    }
}
