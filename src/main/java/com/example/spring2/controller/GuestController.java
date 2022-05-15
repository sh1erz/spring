package com.example.spring2.controller;

import com.example.spring2.model.Category;
import com.example.spring2.services.api.CategoryService;
import com.example.spring2.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class GuestController {

    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping(value = { "/", "/index" })
    public String index(Model model){
        model.addAttribute("root_categories", categoryService.getRootCategories());
        return "index";
    }

    @GetMapping(value = "/ajax/getCategory")
    @ResponseBody
    public Category getCategory(@RequestParam long id){
        return categoryService.getCategory(id);
    }

    @GetMapping(value = "/guest/products")
    public String products(Model model, @RequestParam long id) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);
        return "products";
    }

    @GetMapping(value = "/guest/product")
    public String product(Model model, @RequestParam long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "guest_product";
    }


}
