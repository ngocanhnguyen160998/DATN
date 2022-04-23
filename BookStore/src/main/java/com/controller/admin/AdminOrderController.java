package com.controller.admin;

import com.dto.OrderDTO;
import com.model.Orders;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DataAccess dataAccess;

    public String searchInput = "";

    @GetMapping("/table")
    public ModelAndView product(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search){
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(9);
        pageResponse.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 9);
        List<Orders> lst;

        if (!"all".equals(search)) {
            lst = orderService.getByFullNameAndPhone(searchInput, pageable);
            pageResponse.setTotalItem(orderService.countByFullNameAndPhone(searchInput));
        } else {
            lst = orderService.getAll(pageable);
            pageResponse.setTotalItem(orderService.count());
        }
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        model.addAttribute("input", search);
        model.addAttribute("search", new Search());
        return new ModelAndView("admin/order/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim();
        return new ModelAndView("redirect:/admin/order/table?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
    }

    @RequestMapping("/confirm")
    public ModelAndView confirm(@RequestParam(value = "id") Long id){
        orderService.updateById(id);
        return new ModelAndView("redirect:/admin/order/table?page=1&search=all");
    }

    @RequestMapping("/details")
    public ModelAndView detail(Model model, @RequestParam(value = "id") Long id) {
        OrderDTO orders = dataAccess.getOrderDTOById(id);
        model.addAttribute("item", orders);
        return new ModelAndView("/admin/order/detail");
    }
}
