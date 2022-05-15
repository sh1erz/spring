package com.example.spring2.controller;

import com.example.spring2.model.Category;
import com.example.spring2.repository.entities.CategoryEntity;
import com.example.spring2.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private CategoryService categoryService;

    //private final DataProvider repository = new DataProvider();
    private List<CategoryEntity> categories;

    static String ROOT_CATEGORIES = "root_categories";


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute(ROOT_CATEGORIES, categoryService.getRootCategories());
        return "index";
    }

    @GetMapping(value = "/ajax/getCategory")
    @ResponseBody
    public Category getCategory(@RequestParam long id){
        return categoryService.getCategory(id);
    }



}
