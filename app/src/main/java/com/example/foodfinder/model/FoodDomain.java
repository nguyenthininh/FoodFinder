package com.example.foodfinder.model;

public class FoodDomain {
    private String title;
    private int image;
    private String desc;
    private String place;
    private Double fee;
    private int numberIntCard;

    public FoodDomain(String title, int image, String desc, String place, Double fee) {
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.place = place;
        this.fee = fee;
    }

    public FoodDomain(String title, int image, String desc, String place, Double fee, int numberIntCard) {
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.place = place;
        this.fee = fee;
        this.numberIntCard = numberIntCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberIntCard() {
        return numberIntCard;
    }

    public void setNumberIntCard(int numberIntCard) {
        this.numberIntCard = numberIntCard;
    }
}
