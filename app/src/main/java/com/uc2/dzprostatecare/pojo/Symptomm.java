package com.uc2.dzprostatecare.pojo;

import java.io.Serializable;

public class Symptomm implements Serializable {

    public int itemID;



    private int s_id;
    public String name;
    public String date;
    public String note;
    public String severity;



    public Symptomm(int itemID,int s_id,String date, String severity, String note, String name) {
        this.itemID=itemID;
        this.s_id=s_id;
        this.date = date;
        this.note = note;
        this.severity=severity;
        this.name=name;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }


    public int getItemID() {
        return itemID;
    }

    public String getSeverity() {
        return severity;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }



    public String getName() {
        return name;
    }


    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
