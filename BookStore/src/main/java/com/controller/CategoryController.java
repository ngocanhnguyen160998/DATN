package com.controller;

import com.model.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public ModelAndView findAll(Model model){
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("item", categoryList);
        return new ModelAndView("admin/product/table");
    }
}
