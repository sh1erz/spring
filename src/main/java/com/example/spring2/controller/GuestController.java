package com.example.spring2.controller;

import com.example.spring2.model.Category;
import com.example.spring2.model.ProductFilterForm;
import com.example.spring2.model.ProductPage;
import com.example.spring2.services.api.CategoryService;
import com.example.spring2.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static com.example.spring2.model.Constants.*;

@Controller
public class GuestController {

    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/", "/index"})
    public String index(HttpSession session, Model model) {
        session.setAttribute(IS_LOGGED, false);
        model.addAttribute("categories", categoryService.getRootCategories());
        return "index";
    }

    @GetMapping(value = "/ajax/getCategory")
    @ResponseBody
    public Category getCategory(@RequestParam long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping(value = "/products")
    public String products(Model model, @RequestParam long id) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);
        return "guest_products";
    }

    @GetMapping(value = "/allProducts")
    public String allProducts(
            Model model,
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "direction", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String direction,
            @RequestParam(value = "search", defaultValue = "", required = false) String search
    ) {
        ProductFilterForm form = new ProductFilterForm(sortBy, direction, search);
        model.addAttribute("productFilterForm", form);
        ProductPage page = productService.getProductsPageable(pageNo, pageSize, sortBy, direction);
        model.addAttribute("productPage", page);
        return "guest_all_products";
    }

    @GetMapping(value = "/guest/product")
    public String product(Model model, @RequestParam long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "guest_product";
    }

    public static String IS_LOGGED = "isLogged";
}
