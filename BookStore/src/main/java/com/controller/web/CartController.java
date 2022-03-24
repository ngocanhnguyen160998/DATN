package com.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @RequestMapping("/cart")
    public ModelAndView product(Model model) {

        return new ModelAndView("web/cart");
    }
}
