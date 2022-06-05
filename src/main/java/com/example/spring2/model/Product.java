package com.example.spring2.model;

public class Product {
    private long id = -1;
    private String name;
    private int price;
    private long categoryId;
    private Availability availability;

    public Product(){}

    public Product(long id, String name, int price, long categoryId, Availability availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.availability = availability;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
