package com.controller.admin;

import com.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @RequestMapping("/order/table")
    public ModelAndView product(Model model){
//        List<Product> lst = productService.getAll();
//        model.addAttribute("item", lst);
        return new ModelAndView("admin/order/table");
    }
}
