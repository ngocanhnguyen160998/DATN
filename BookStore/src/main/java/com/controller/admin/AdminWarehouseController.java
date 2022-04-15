package com.controller.admin;

import com.dto.WarehouseDTO;
import com.model.Product;
import com.model.Warehouse;
import com.model.response.PageResponse;
import com.repository.DataAccess;
import com.service.ProductService;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/warehouse")
public class AdminWarehouseController {
    @Autowired
    private DataAccess dataAccess;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/table")
    public ModelAndView warehouse(Model model, @RequestParam("page") int page) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(10);
        pageResponse.setPage(page);
        pageResponse.setTotalItem(warehouseService.count());
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

        Pageable pageable = PageRequest.of(page - 1, 10);
        List<WarehouseDTO> lst = dataAccess.getListWarehouseDTO(pageable).getContent();

//        List<Warehouse> lst = warehouseService.getAll(pageable);
        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        return new ModelAndView("admin/warehouse/table");
    }

    @GetMapping("/edit")
    public ModelAndView warehouseEdit(@RequestParam(value = "id") Long id, Model model){
        List<Product> productList = productService.getAll();
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        WarehouseDTO lst = dataAccess.findWarehouseById(id);
        model.addAttribute("item", lst);
        model.addAttribute("productList",productList);
        model.addAttribute("warehouse",warehouseDTO);
        return new ModelAndView("admin/warehouse/edit");
    }

    @PostMapping("/edit")
    public ModelAndView submitFormEdit(@ModelAttribute("warehouse") WarehouseDTO warehouseDTO){
        warehouseService.updateById(warehouseDTO.getId(), warehouseDTO);
        return new ModelAndView("redirect:/admin/warehouse/table");
    }

    @GetMapping("/insert")
    public ModelAndView warehouseInsert(Model model){
        Warehouse warehouse = new Warehouse();
        List<Product> lst = productService.getAllProductNotExistWarehouse();
        model.addAttribute("item", lst);
        model.addAttribute("warehouse", warehouse);
        return new ModelAndView("admin/warehouse/insert");
    }

    @PostMapping("/insert")
    public ModelAndView submitFormInsert(@ModelAttribute("warehouse") Warehouse warehouse){
        warehouseService.insert(warehouse);
        return new ModelAndView("redirect:/admin/warehouse/table");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView warehouseDelete(@RequestParam(value = "id") Long id){
        warehouseService.deleteById(id);
        return new ModelAndView("redirect:/admin/warehouse/table");
    }
}
