package com.example.spring2.services.impl;

import com.example.spring2.model.Category;
import com.example.spring2.repository.DAO;
import com.example.spring2.services.api.CategoryService;
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
    public Category getCategory(long categoryId) {
        return dao.getCategoryById(categoryId);
    }

    @Override
    public boolean deleteCategory(long id) {
        return dao.deleteCategory(id);
    }

    @Override
    public boolean addCategory(String name, long parentCategoryId) {
        return dao.addCategory(name, parentCategoryId);
    }
}
