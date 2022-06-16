package com.example.spring2.model;

import javax.validation.constraints.*;

public class Product {
    private long id = -1;

    @NotBlank(message = "Product name can't be blank")
    @NotNull(message = "Product title can't be empty")
    @Size(min = 2, message = "Product title size must be at least 2")
    @Pattern(regexp = "[^<>]*", message = "Product title should not contain '<' or '>'")
    private String name;

    @NotNull(message = "Product price can't be empty")
    @Digits(integer = 4, fraction = 0, message = "Product price should be a whole number in range 0 to 9999")
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
