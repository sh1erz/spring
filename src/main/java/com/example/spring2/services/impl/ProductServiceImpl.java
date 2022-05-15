package com.example.spring2.services.impl;

import com.example.spring2.model.Product;
import com.example.spring2.repository.DAO;
import com.example.spring2.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    DAO dao;

    public ProductServiceImpl( @Autowired DAO dao) {
        this.dao = dao;
    }

    @Override
    public Product getProduct(long productId) {
        return dao.getProductById(productId);
    }

    @Override
    public boolean setProductPrice(long productId, int price) {
        return false;
    }

    @Override
    public Product changeProductName(long productId, String name) {
        return null;
    }
}
