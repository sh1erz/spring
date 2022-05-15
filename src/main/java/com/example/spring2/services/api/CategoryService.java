package com.example.spring2.services.api;

import com.example.spring2.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getRootCategories();

    Category getCategory(long categoryId);
}
