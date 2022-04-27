package com.controller.admin;

import com.dto.OrderDetailDTO;
import com.model.Orders;
import com.model.OrdersDetails;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.model.response.SearchDate;
import com.repository.DataAccess;
import com.service.OrderService;
import com.service.OrdersDetailsService;
import com.service.WarehouseService;
import com.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrdersDetailsService ordersDetailsService;

    @Autowired
    private WarehouseService warehouseService;

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
        model.addAttribute("searchDate", new SearchDate());
        return new ModelAndView("admin/order/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim();
        return new ModelAndView("redirect:/admin/order/table?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
    }

    @RequestMapping("/finish")
    public ModelAndView finish(@RequestParam(value = "id") Long id){
        orderService.updateFinishById(id);
        return new ModelAndView("redirect:/admin/order/table?page=1&search=all");
    }

    @RequestMapping("/confirm")
    public ModelAndView confirm(@RequestParam(value = "id") Long id){
        orderService.updateConfirmById(id);
        return new ModelAndView("redirect:/admin/order/table?page=1&search=all");
    }

    @RequestMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "id") Long id){
        List<OrdersDetails> lst = ordersDetailsService.getAllByOrderId(id);
        for (OrdersDetails od : lst) {
            warehouseService.updateAmountByProductId(od.getProductId(), od.getAmount());
        }
        orderService.updateCancelById(id);
        return new ModelAndView("redirect:/admin/order/table?page=1&search=all");
    }

    @RequestMapping("/details")
    public ModelAndView detail(Model model, @RequestParam(value = "id") Long id) {
        List<OrderDetailDTO> orders = dataAccess.getOrderDTOById(id);
        model.addAttribute("lstItem", orders);
        model.addAttribute("item", orders.get(0));
        return new ModelAndView("/admin/order/detail");
    }

    @PostMapping("/export-excel")
    public void exportExcel(HttpServletResponse response, @ModelAttribute("searchDate") SearchDate searchDate){
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ListOrder_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<OrderDetailDTO> lst = dataAccess.getListOrderDTO(searchDate);
        ExportExcel exportExcel = new ExportExcel(lst);
        exportExcel.export(response);
    }
}
