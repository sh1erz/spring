package com.example.spring2.repository.entities;

public class CategoryEntity {
    private final long id;
    private String name;
    private long categoryId = -1;

    public CategoryEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryEntity(long id, String name, long categoryId) {
        this(id, name);
        this.categoryId = categoryId;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
