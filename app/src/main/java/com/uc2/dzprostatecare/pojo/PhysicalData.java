package com.uc2.dzprostatecare.pojo;

public class PhysicalData {

    private int id;
    private String psa;
    private String pulse;
    private String pressure;
    private String temp;
    private String glucose;

    public PhysicalData(int id, String psa, String pulse, String pressure, String temp, String glucose) {
        this.id = id;
        this.psa = psa;
        this.pulse = pulse;
        this.pressure = pressure;
        this.temp = temp;
        this.glucose = glucose;
    }

    public int getId() {
        return id;
    }

    public String getPsa() {
        return psa;
    }

    public String getPulse() {
        return pulse;
    }

    public String getPressure() {
        return pressure;
    }

    public String getTemp() {
        return temp;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPsa(String psa) {
        this.psa = psa;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }
}
