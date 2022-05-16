package com.example.spring2.controller;

import com.example.spring2.services.api.CategoryService;
import com.example.spring2.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;


    @GetMapping(value = {"/admin/categories"})
    public String categories(Model model) {
        model.addAttribute("root_categories", categoryService.getRootCategories());
        return "admin_categories";
    }

    @PostMapping(value = "/admin/categories/create")
    public Boolean addCategory(@RequestBody String categoryName, Long parentCategoryId) {
        long parentCategoryId1 = parentCategoryId != null ? parentCategoryId : -1;
        return categoryService.addCategory(categoryName, parentCategoryId1);
    }

    @PostMapping(value = "/admin/categories/remove")
    public Boolean removeCategory(@RequestBody long id) {
        return categoryService.deleteCategory(id);
    }

    @GetMapping(value = "/admin/product")
    public String product(Model model, @RequestParam long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "admin_product";
    }
}
