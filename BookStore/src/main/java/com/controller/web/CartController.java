package com.controller.web;

import com.model.response.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @RequestMapping("/cart")
    public ModelAndView product(Model model) {
        model.addAttribute("search", new Search());
        return new ModelAndView("web/cart");
    }
}
