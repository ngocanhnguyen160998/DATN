package com.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductDetailController {

    @RequestMapping("/product-detail")
    public ModelAndView product(Model model, @RequestParam("id") Long id) {

        return new ModelAndView("web/product_detail");
    }
}
