package com.uc2.dzprostatecare.pojo;

import android.widget.TextView;

public class Consultation {

    public int itemID;
    public int idConsultation;
    public String name;
    public String date;
    public String summary;






    public Consultation(int idConsultation,int itemID,String date, String summary,String name) {
        this.idConsultation=idConsultation;
        this.itemID=itemID;
        this.name=name;
        this.date = date;
        this.summary = summary;
    }



    public String getName() {
        return name;
    }


    public String getDate() {
        return date;
    }

    public String getSummary() {
        return summary;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }



    public int getItemID() {
        return itemID;
    }

    public int getIdConsultation() {
        return idConsultation;
    }
}
