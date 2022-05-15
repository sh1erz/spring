package com.example.spring2.repository;

import com.example.spring2.model.Category;

import java.util.List;

public interface DAO {

    List<Category> getRootCategories();

    Category getCategoryById(long id);

}
