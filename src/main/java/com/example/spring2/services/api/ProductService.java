package com.example.spring2.services.api;

import com.example.spring2.model.Product;
import com.example.spring2.model.ProductPage;

public interface ProductService {
    ProductPage getProductsPageable(int pageNo, int pageSize, String sortBy, String sortDir);

    Product getProduct(long productId);

    boolean postProduct(Product product);

    boolean removeProduct(long productId);
}
