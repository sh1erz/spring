package com.example.spring2.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Category {
    private long id = -1;
    @NotBlank(message = "Category title can't be blank")
    @NotNull(message = "Category title can't be empty")
    @Size(min = 2, message = "Category title size must be at least 2")
    @Pattern(regexp = "[^<>]*", message = "Category title should not contain '<' or '>'")
    private String name;
    private List<Category> categories;
    private List<Product> products;
    private long rootId = -1;

    public Category() {
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(long id, String name, List<Category> categories, List<Product> products, long rootId) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.products = products;
        this.rootId = rootId;
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

    public long getRootId() {
        return rootId;
    }

    public void setRootId(long rootId) {
        this.rootId = rootId;
    }
}
