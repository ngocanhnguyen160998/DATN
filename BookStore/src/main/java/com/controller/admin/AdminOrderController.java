package com.controller.admin;

import com.model.Orders;
import com.model.response.PageResponse;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/table")
    public ModelAndView product(Model model, @RequestParam("page") int page){
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(10);
        pageResponse.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 10);
        List<Orders> lst = orderService.getAll(pageable);
        pageResponse.setTotalItem(orderService.count());
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));


        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        return new ModelAndView("admin/order/table");
    }
}
