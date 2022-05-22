package com.example.spring2.controller;

import com.example.spring2.model.Category;
import com.example.spring2.model.Product;
import com.example.spring2.services.api.CategoryService;
import com.example.spring2.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("categories", categoryService.getRootCategories());
        return "admin_categories";
    }

    @GetMapping(value = {"/admin/category"})
    public String category(Model model, @RequestParam long id) {
        Category category = categoryService.getCategory(id);
        if(category == null) return "redirect:/exception?message=" + "Category id was wrong";
        model.addAttribute("category", category);
        return "admin_category";
    }

    @GetMapping(value = "/admin/categories/create")
    public String addCategory(@RequestParam String name, @RequestParam long rootId) {
        Category newCategory = new Category(-1, name, null, null, rootId);
        if (categoryService.postCategory(newCategory)) {
            return "redirect:/admin/category?id=" + rootId;
        } else return "redirect:/exception?message=" + "Category could not be created";
    }

    @PostMapping(value = "/admin/changeCategory")
    public String changeCategory(@ModelAttribute Category category) {
        if (category != null && categoryService.postCategory(category)) {
            return "redirect:/admin/category?id=" + category.getId();
        } else return "redirect:/exception?message=" + "Category could not be changed";
    }

    @PostMapping(value = "/admin/removeCategory")
    public String removeCategory(@ModelAttribute Category category) {
        if (categoryService.deleteCategory(category.getId())) {
            return "redirect:/admin/categories";
        } else return "redirect:/exception?message=" + "Category could not be removed";
    }

    //Products

    @GetMapping(value = "/admin/products")
    public String products(Model model, @RequestParam long id) {
        Category category = categoryService.getCategory(id);
        if(category == null) return "redirect:/exception?message=" + "Category id was wrong";
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
        } else return "redirect:/exception?message=" + "Product could not be posted";
    }

    @GetMapping(value = "/admin/deleteProduct")
    public String deleteProduct(@RequestParam long productId, @RequestParam long categoryId) {
        if (productService.removeProduct(productId)) {
            return "redirect:/admin/products?id=" + categoryId;
        } else return "redirect:/exception?message=" + "Product could not be removed";
    }

}
