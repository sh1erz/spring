package com.example.spring2.services.api;

import com.example.spring2.model.Product;

public interface ProductService {
    Product getProduct(long productId);
    boolean setProductPrice(long productId, int price);
    Product changeProductName(long productId, String name);
}
