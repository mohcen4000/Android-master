package com.uc2.dzprostatecare.pojo;

public class TestResult {

    private int idtest;
    private int idpatient;
    private int idurologist;
    private String value;
    private String notes;
    private String addon;
    private String returndate;
    private String step;
    private String status;
    private String dueon;
    private String infogiven;
    private Test test;



    public TestResult(int idtest, int idpatient, int idurologist, String value, String notes, String addon, String returndate, String step, String status, String dueon, String infogiven, Test test) {
        this.idtest = idtest;
        this.idpatient = idpatient;
        this.idurologist = idurologist;
        this.value = value;
        this.notes = notes;
        this.addon = addon;
        this.returndate = returndate;
        this.step = step;
        this.status = status;
        this.dueon = dueon;
        this.infogiven = infogiven;
        this.test=test;
    }

    public int getIdtest() {
        return idtest;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public int getIdurologist() {
        return idurologist;
    }

    public String getValue() {
        return value;
    }

    public String getNotes() {
        return notes;
    }

    public String getAddon() {
        return addon;
    }

    public String getReturndate() {
        return returndate;
    }

    public String getStep() {
        return step;
    }

    public String getStatus() {
        return status;
    }

    public String getDueon() {
        return dueon;
    }

    public String getInfogiven() {
        return infogiven;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public void setIdurologist(int idurologist) {
        this.idurologist = idurologist;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueon(String dueon) {
        this.dueon = dueon;
    }

    public void setInfogiven(String infogiven) {
        this.infogiven = infogiven;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }
}
