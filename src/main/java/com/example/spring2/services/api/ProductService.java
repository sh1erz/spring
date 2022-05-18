package com.example.spring2.services.api;

import com.example.spring2.model.Product;

public interface ProductService {
    Product getProduct(long productId);
    boolean postProduct(Product product);
    boolean removeProduct(long productId);
}
