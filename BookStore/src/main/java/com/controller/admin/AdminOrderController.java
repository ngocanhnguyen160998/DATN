package com.controller.admin;

import com.model.Orders;
import com.model.Product;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/table")
    public ModelAndView product(Model model){
        List<Orders> lst = orderService.getAll();
        model.addAttribute("item", lst);
        return new ModelAndView("admin/order/table");
    }
}
