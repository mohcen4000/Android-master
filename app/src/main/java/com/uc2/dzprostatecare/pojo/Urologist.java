package com.uc2.dzprostatecare.pojo;

public class Urologist {

    private int id,phone;
    private String first_name,last_name,birthdate,u_grade,email;

    public Urologist(int id, int phone, String first_name, String last_name, String birthdate, String u_grade, String email) {
        this.id = id;
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.u_grade = u_grade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getU_grade() {
        return u_grade;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setU_grade(String u_grade) {
        this.u_grade = u_grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
