package com.example.spring2.repository;

import com.example.spring2.model.Category;
import com.example.spring2.model.Product;
import com.example.spring2.repository.entities.CategoryEntity;
import com.example.spring2.repository.entities.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataProvider implements DAO {

    public List<Category> getRootCategories() {
        return categories.stream().filter(category -> category.getCategoryId() == -1)
                .map(this::categoryEntityToDomain).collect(Collectors.toList());
    }

    public Category getCategoryById(long id) {
        return categories.stream().filter(c -> c.getId() == id).findFirst()
                .map(this::categoryEntityToDomain).orElse(null);
    }

    private List<Product> getProductsInCategory(CategoryEntity categoryEntity) {
        return productEntities.stream().filter(productEntity -> productEntity.getCategoryId() == categoryEntity.getId())
                .map(pe -> new Product(pe.getId(), pe.getName(), pe.getPrice())).collect(Collectors.toList());
    }

    private List<Category> getSubcategories(CategoryEntity categoryEntity) {
        return categories.stream().filter(subcategory -> subcategory.getCategoryId() == categoryEntity.getId())
                .map(this::categoryEntityToDomain).collect(Collectors.toList());

    }

    private Category categoryEntityToDomain(CategoryEntity ce) {
        return new Category(ce.getId(), ce.getName(), getSubcategories(ce), getProductsInCategory(ce));
    }


    private final List<ProductEntity> productEntities = List.of(
            new ProductEntity(0, "Accessoire 1", 50, 2),
            new ProductEntity(2, "Accessoire 2", 60, 2),
            new ProductEntity(3, "Accessoire 3", 70, 2),
            new ProductEntity(4, "Phone", 500, 3),
            new ProductEntity(5, "Lighting", 100, 5),
            new ProductEntity(6, "Lighting2", 110, 5)
    );
   private final List<CategoryEntity> categories = List.of(
            new CategoryEntity(0, "Electronics"),
            new CategoryEntity(1, "Smart Home"),
            new CategoryEntity(2, "Accessories", 0),
            new CategoryEntity(3, "Cell Phones", 0),
            new CategoryEntity(4, "Smart Home Lighting", 1),
            new CategoryEntity(5, "Smart Home Lighting A1", 4)
    );
}
