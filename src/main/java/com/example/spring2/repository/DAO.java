package com.example.spring2.repository;

import com.example.spring2.model.Category;
import com.example.spring2.model.Product;

import java.util.List;

public interface DAO {

    List<Category> getRootCategories();

    Category getCategoryById(long id);

    boolean deleteCategory(long id);

    boolean addCategory(String name, long parentCategoryId);

    Product getProductById(long id);

}
