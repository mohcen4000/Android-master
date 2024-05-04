package com.uc2.dzprostatecare.pojo;

import java.io.Serializable;

public class Patient implements Serializable{

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phone;
    private String birthdate;
    private String bloodtype;
    private String address;
    private String jobdescription;
    private String alcoholintake;
    private String smoking;
    private String emergencycontact;
    private String region;
    private String familyHistory;
    private String ethencity;
    private String placeresidence;
    private String familialSituation;
    private String ac_status;


    public Patient(int id, String firstName, String lastName, String email, String password, int phone, String birthdate, String bloodtype, String address, String jobdescription, String alcoholintake, String smoking, String emergencycontact, String region, String familyHistory, String ethencity, String placeresidence, String familialSituation, String ac_status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthdate = birthdate;
        this.bloodtype = bloodtype;
        this.address = address;
        this.jobdescription = jobdescription;
        this.alcoholintake = alcoholintake;
        this.smoking = smoking;
        this.emergencycontact = emergencycontact;
        this.region = region;
        this.familyHistory = familyHistory;
        this.ethencity = ethencity;
        this.placeresidence = placeresidence;
        this.familialSituation = familialSituation;
        this.ac_status = ac_status;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public String getAddress() {
        return address;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public String getAlcoholintake() {
        return alcoholintake;
    }

    public String getSmoking() {
        return smoking;
    }

    public String getEmergencycontact() {
        return emergencycontact;
    }

    public String getRegion() {
        return region;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public String getEthencity() {
        return ethencity;
    }

    public String getPlaceresidence() {
        return placeresidence;
    }

    public String getFamilialSituation() {
        return familialSituation;
    }

    public String getAc_status() {
        return ac_status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public void setAlcoholintake(String alcoholintake) {
        this.alcoholintake = alcoholintake;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public void setEmergencycontact(String emergencycontact) {
        this.emergencycontact = emergencycontact;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public void setEthencity(String ethencity) {
        this.ethencity = ethencity;
    }

    public void setPlaceresidence(String placeresidence) {
        this.placeresidence = placeresidence;
    }

    public void setFamilialSituation(String familialSituation) {
        this.familialSituation = familialSituation;
    }

    public void setAc_status(String ac_status) {
        this.ac_status = ac_status;
    }
}
