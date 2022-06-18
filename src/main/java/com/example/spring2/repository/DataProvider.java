package com.example.spring2.repository;

import com.example.spring2.model.Availability;
import com.example.spring2.model.Category;
import com.example.spring2.model.Product;
import com.example.spring2.repository.entities.CategoryEntity;
import com.example.spring2.repository.entities.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public boolean deleteCategory(long id) {
        return categories.removeIf(ce -> ce.getId() == id);
    }

    @Override
    public boolean addCategory(Category category) {
        CategoryEntity existingCategory = categories.stream().filter(c -> c.getId() == category.getId()).findFirst().orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return true;
        }
        return categories.add(categoryDomainToEntity(category));
    }

    @Override
    public Product getProductById(long id) {
        return productEntities.stream().filter(p -> p.getId() == id).findFirst()
                .map(this::productEntityToDomain).orElse(null);
    }

    @Override
    public boolean addProduct(Product product) {
        ProductEntity existingProduct = productEntities.stream().filter(p -> p.getId() == product.getId()).findFirst().orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return true;
        }
        return productEntities.add(productDomainToEntity(product));
    }

    @Override
    public boolean removeProduct(long productId) {
        return productEntities.removeIf(pe -> pe.getId() == productId);
    }

    @Override
    public List<Product> getProducts() {
        return productEntities.stream().map(this::productEntityToDomain).collect(Collectors.toList());
    }

    private List<Product> getProductsInCategory(CategoryEntity categoryEntity) {
        return productEntities.stream().filter(productEntity -> productEntity.getCategoryId() == categoryEntity.getId())
                .map(pe -> new Product(pe.getId(), pe.getName(), pe.getPrice(), pe.getCategoryId(), Availability.valueOf(pe.getAvailability()))).collect(Collectors.toList());
    }

    private List<Category> getSubcategories(CategoryEntity categoryEntity) {
        return categories.stream().filter(subcategory -> subcategory.getCategoryId() == categoryEntity.getId())
                .map(this::categoryEntityToDomain).collect(Collectors.toList());

    }

    private Category categoryEntityToDomain(CategoryEntity ce) {
        return new Category(ce.getId(), ce.getName(), getSubcategories(ce), getProductsInCategory(ce), ce.getCategoryId());
    }

    private CategoryEntity categoryDomainToEntity(Category c) {
        return new CategoryEntity(++categoryId, c.getName(), c.getRootId());
    }

    private Product productEntityToDomain(ProductEntity pe) {
        return new Product(pe.getId(), pe.getName(), pe.getPrice(), pe.getCategoryId(), Availability.valueOf(pe.getAvailability()));
    }

    private ProductEntity productDomainToEntity(Product p) {
        return new ProductEntity(++productId, p.getName(), p.getPrice(), p.getCategoryId());
    }

    static int productId = 6;
    static int categoryId = 5;

    private final List<ProductEntity> productEntities = new ArrayList<>();
    private final List<CategoryEntity> categories = new ArrayList<>();

    public DataProvider() {
        productEntities.addAll(Arrays.asList(
                new ProductEntity(0, "Accessoire 1", 50, 2),
                new ProductEntity(2, "Accessoire 2", 60, 2, "LIMITED"),
                new ProductEntity(3, "Accessoire 3", 70, 2, "ABSENT"),
                new ProductEntity(4, "Phone", 500, 3),
                new ProductEntity(5, "Lighting", 100, 5),
                new ProductEntity(6, "Lighting2", 110, 5),
                new ProductEntity(7, "Phone 2", 501, 3),
                new ProductEntity(8, "Accessoire 4", 50, 2),
                new ProductEntity(9, "Accessoire 5", 60, 2, "LIMITED"),
                new ProductEntity(10, "Accessoire 6", 70, 2, "ABSENT"),
                new ProductEntity(11, "Accessoire 7", 50, 2),
                new ProductEntity(12, "Accessoire 8", 60, 2, "LIMITED"),
                new ProductEntity(13, "Accessoire 9", 70, 2, "ABSENT"),
                new ProductEntity(14, "Accessoire 10", 50, 2),
                new ProductEntity(15, "Accessoire 11", 60, 2, "LIMITED"),
                new ProductEntity(16, "Accessoire 12", 70, 2, "ABSENT"),
                new ProductEntity(17, "Accessoire 13", 50, 2),
                new ProductEntity(18, "Accessoire 14", 60, 2, "LIMITED"),
                new ProductEntity(19, "Accessoire 15", 70, 2, "ABSENT"),
                new ProductEntity(20, "Accessoire 16", 50, 2),
                new ProductEntity(21, "Accessoire 17", 60, 2, "LIMITED"),
                new ProductEntity(22, "Accessoire 18", 70, 2, "ABSENT"),
                new ProductEntity(23, "Accessoire 19", 50, 2),
                new ProductEntity(24, "Accessoire 20", 60, 2, "LIMITED"),
                new ProductEntity(25, "Accessoire 21", 70, 2, "ABSENT")
        ));
        categories.addAll(Arrays.asList(
                new CategoryEntity(0, "Electronics"),
                new CategoryEntity(1, "Smart Home"),
                new CategoryEntity(2, "Accessories", 0),
                new CategoryEntity(3, "Cell Phones", 0),
                new CategoryEntity(4, "Smart Home Lighting", 1),
                new CategoryEntity(5, "Smart Home Lighting A1", 4)
        ));
    }

}
