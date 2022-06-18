package com.example.spring2.repository;

import com.example.spring2.model.Product;
import com.example.spring2.model.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    DAO dao;

    public ProductRepositoryImpl(@Autowired DAO dao) {
        this.dao = dao;
    }


    private Comparator<Product> getComparator(String sortBy) {
        if (sortBy.equals("NAME")) {
            return Comparator.comparing(Product::getName);
        } else {
            return Comparator.comparing(Product::getPrice);
        }
    }

    private ProductPage createPage(List<Product> products, Integer pageNo, Integer pageSize) {
        int totalPages = (int) Math.ceil(products.size() / pageSize.floatValue());
        int fromIndex = (pageNo - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        boolean last = false;
        if (toIndex >= products.size()) {
            last = true;
            toIndex = products.size() - 1;
        }
        return new ProductPage(products.subList(fromIndex, toIndex), pageNo, pageSize, products.size(), totalPages, last);
    }

    @Override
    public ProductPage findAll(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        List<Product> products = dao.getProducts();
        products.sort(getComparator(sortBy));
        if (direction.equals("DESC")) {
            Collections.reverse(products);
        }
        return createPage(products, pageNo, pageSize);
    }
}