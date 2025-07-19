package com.menglang.nestedrecyclerview.model;

public class Product {
    private String title;
    private String imageUrl; // URL instead of int drawable

    public Product(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
}
