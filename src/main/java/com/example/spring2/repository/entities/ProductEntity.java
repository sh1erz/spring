package com.example.spring2.repository.entities;

public class ProductEntity {

    private final long id;
    private String name;
    private int price;
    private long categoryId;
    /**
     * Available by default
     */
    private String availability = "AVAILABLE";

    public ProductEntity(long id, String name, int price, long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public ProductEntity(long id, String name, int price, long categoryId, String availability) {
        this(id, name, price, categoryId);
        this.availability = availability;
    }

    public long getId() {
        return id;
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
