package com.example.spring2.model;

public class ProductFilterForm {
    private String sortBy;

    private String direction;

    private String search;

    public ProductFilterForm() {
    }

    public ProductFilterForm(String sortBy, String direction, String search) {
        this.sortBy = sortBy;
        this.direction = direction;
        this.search = search;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}