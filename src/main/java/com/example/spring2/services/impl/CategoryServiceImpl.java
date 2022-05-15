package com.example.spring2.services.impl;

import com.example.spring2.model.Category;
import com.example.spring2.repository.DAO;
import com.example.spring2.services.api.CategoryService;
import com.fasterxml.jackson.core.JsonEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private DAO dao;

    @Autowired
    private void setDao(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Category> getRootCategories() {
        return dao.getRootCategories();
    }

    @Override
    public List<Category> getSubCategories(long categoryId) {
        Category category = dao.getCategoryById(categoryId);
        return dao.getSubcategories(category);
    }

}
