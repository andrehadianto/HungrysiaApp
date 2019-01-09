package com.example.andre.hungrysiaapp;

public class MenuItem {
    private String name;
    private double price;
    private int thumbnail;

    public MenuItem(){
    }

    public MenuItem(String name, double price, int thumbnail) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getThumbnail() {
        return thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
