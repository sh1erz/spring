package com.example.spring2.repository;

import com.example.spring2.model.Category;
import com.example.spring2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataProvider implements DAO{

    public Category getCategoryById(long id){
        List<Category> category = categories.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
        if (category.size() > 0) return category.get(0);
        else throw new IllegalArgumentException();
    }
    public List<Product> getProductsInCategory(Category category) {
        return products.stream().filter(product -> product.getCategoryId() == category.getId()).collect(Collectors.toList());
    }

    public List<Category> getSubcategories(Category category) {
        return categories.stream().filter(subcategory -> subcategory.getCategoryId() == category.getId()).collect(Collectors.toList());
    }

    public List<Category> getRootCategories(){
        return categories.stream().filter(category -> category.getCategoryId() == -1).collect(Collectors.toList());
    }

    List<Product> products = List.of(
            new Product(0, "Accessoire 1", 50, 2),
            new Product(2, "Accessoire 2", 60, 2),
            new Product(3, "Accessoire 3", 70, 2),
            new Product(4, "Phone", 500, 3),
            new Product(5, "Lighting", 100, 4),
            new Product(6, "Lighting2", 110, 4)
    );
    List<Category> categories = List.of(
            new Category(0, "Electronics"),
            new Category(1, "Smart Home"),
            new Category(2, "Accessories", 0),
            new Category(3, "Cell Phones", 0),
            new Category(4, "Smart Home Lighting", 1)
    );
}
