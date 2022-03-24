package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductManagerController {

    @RequestMapping("/admin-product-table")
    public ModelAndView get(Model model){
//        model.addAttribute("name", name);
        return new ModelAndView("admin/product/table");
    }

}
