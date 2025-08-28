package com.geeks.homework_2_6;

public class FoodItem {
    private String image;
    private String name;
    private String price;
    private float rating;

    public FoodItem(String image, String name, String price, float rating) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
