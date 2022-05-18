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
    public boolean postProduct(Product product) {
        return dao.addProduct(product);
    }

    @Override
    public boolean removeProduct(long productId) {
        return dao.removeProduct(productId);
    }
}
