package com.uc2.dzprostatecare.pojo;

import java.io.Serializable;

public class Appointment implements Serializable {

    private int id;
    private String bookedOn;
    private String status;
    private int id_patient;
    private int id_urologist;
    private String type;
    private String scheduledOn;
    private String instruction;
    private String reason;

    public Appointment(int id, String bookedOn, String status, int id_patient, int id_urologist, String type, String scheduledOn, String instruction, String reason) {
        this.id = id;
        this.bookedOn = bookedOn;
        this.status = status;
        this.id_patient = id_patient;
        this.id_urologist = id_urologist;
        this.type = type;
        this.scheduledOn = scheduledOn;
        this.instruction = instruction;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public String getBookedOn() {
        return bookedOn;
    }

    public String getStatus() {
        return status;
    }

    public int getId_patient() {
        return id_patient;
    }

    public int getId_urologist() {
        return id_urologist;
    }

    public String getType() {
        return type;
    }

    public String getScheduledOn() {
        return scheduledOn;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getReason() {
        return reason;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookedOn(String bookedOn) {
        this.bookedOn = bookedOn;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public void setId_urologist(int id_urologist) {
        this.id_urologist = id_urologist;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScheduledOn(String scheduledOn) {
        this.scheduledOn = scheduledOn;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
