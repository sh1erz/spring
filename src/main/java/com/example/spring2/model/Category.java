package com.example.spring2.model;

import java.util.List;

public class Category {
    private final long id;
    private String name;
    private List<Category> categories;
    private List<Product> products;

    public Category(long id, String name, List<Category> categories, List<Product> products) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.products = products;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
