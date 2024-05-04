package com.uc2.dzprostatecare.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popular {

    //@SerializedName("name")
    //@Expose
    private String name;
    //@SerializedName("imageUrl")
    //@Expose
    private String imageUrl;
    //@SerializedName("rating")
    //@Expose
    private String rating;
    //@SerializedName("deliveryTime")
    //@Expose
    //@SerializedName("deliveryCharges")
    //@Expos
    //@SerializedName("price")
    //@Expose
    //@SerializedName("note")
    //@Expose
    private String note;

    private String carolic,carboh,protein,lipides;

    public Popular(String name, String imageUrl, String rating, String note, String carolic, String carboh, String protein, String lipides) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.note = note;
        this.carolic = carolic;
        this.carboh = carboh;
        this.protein = protein;
        this.lipides = lipides;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public String getNote() {
        return note;
    }

    public String getCarolic() {
        return carolic;
    }

    public String getCarboh() {
        return carboh;
    }

    public String getProtein() {
        return protein;
    }

    public String getLipides() {
        return lipides;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCarolic(String carolic) {
        this.carolic = carolic;
    }

    public void setCarboh(String carboh) {
        this.carboh = carboh;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public void setLipides(String lipides) {
        this.lipides = lipides;
    }
}
