package com.example.spring2.controller;

import com.example.spring2.model.Category;
import com.example.spring2.model.Product;
import com.example.spring2.services.api.CategoryService;
import com.example.spring2.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;


    @GetMapping(value = {"/admin/categories"})
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.getRootCategories());
        return "admin_categories";
    }

    @GetMapping(value = {"/admin/category"})
    public String category(Model model, @RequestParam long id) {
        model.addAttribute("category", categoryService.getCategory(id));
        model.addAttribute("newCategory", new Category());
        return "admin_category";
    }

    @PostMapping(value = "/admin/categories/create")
    public Boolean addCategory(@ModelAttribute Category newCategory) {
        return categoryService.addCategory(newCategory);
    }

    @PostMapping(value = "/admin/categories/remove")
    public Boolean removeCategory(@RequestBody long id) {
        return categoryService.deleteCategory(id);
    }

    //Products

    @GetMapping(value = "/admin/products")
    public String products(Model model, @RequestParam long id) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("product", new Product());
        return "admin_products";
    }

    @GetMapping(value = "/admin/product")
    public String product(Model model, @RequestParam long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "admin_product";
    }

    @PostMapping(value = "/admin/postProduct")
    public String postProduct(@ModelAttribute Product product) {
        if (product != null && productService.postProduct(product)) {
            return "redirect:/admin/products?id=" + product.getCategoryId();
        } else return "error";
    }

    @GetMapping(value = "/admin/deleteProduct")
    public String deleteProduct(@RequestParam long productId, @RequestParam long categoryId) {
        if (productService.removeProduct(productId)) {
            return "redirect:/admin/products?id=" + categoryId;
        } else return "error";
    }

    public static String BASE_URL = "http://localhost:8080/";

}
