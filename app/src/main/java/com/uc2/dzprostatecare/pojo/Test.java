package com.uc2.dzprostatecare.pojo;


public class Test {

    private int picId;
    private String testName;
    private String testDescription;
    private String testUnit;
    private String image;



    public Test(int picId, String testName, String testDescription, String testUnit, String image) {
        this.picId = picId;
        this.testName = testName;
        this.testDescription = testDescription;
        this.testUnit = testUnit;
        this.image=image;

    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public int getPicId() {
        return picId;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public String getTestUnit() {
        return testUnit;
    }


    public void setPicId(int picId) {
        this.picId = picId;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public void setTestUnit(String testUnit) {
        this.testUnit = testUnit;
    }

}
