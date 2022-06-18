package com.example.spring2.model;

import java.util.List;

public class ProductPage {
    private final int pageNo;
    private final int pageSize;
    private final long totalElements;
    private final int totalPages;
    private final boolean last;
    List<Product> products;

    public ProductPage(List<Product> products, int pageNo, int pageSize, long totalElements, int totalPages, boolean last) {
        this.products = products;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isLast() {
        return last;
    }
}
