package com.controller.admin;

import com.dto.WarehouseDTO;
import com.repository.DataAccess;
import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminWarehouseController {
    @Autowired
    private DataAccess dataAccess;
    @Autowired
    private BaseService baseService;

    @RequestMapping("/warehouse/table")
    public ModelAndView warehouse(Model model) {
        List<WarehouseDTO> lst = dataAccess.getListWarehouseDTO();
        model.addAttribute("item", lst);
        return new ModelAndView("admin/warehouse/table");
    }

    @RequestMapping("/warehouse/edit")
    public ModelAndView warehouseEdit(@RequestParam(value = "id") Long id, Model model){
        WarehouseDTO lst = dataAccess.findWarehouseById(id);
        model.addAttribute("item", lst);
        return new ModelAndView("admin/warehouse/edit");
    }

    @RequestMapping("/warehouse/insert")
    public ModelAndView warehouseInsert(Model model){
//        WarehouseDTO lst = dataAccess.findWarehouseById(id);
//        model.addAttribute("item", lst);
        return new ModelAndView("admin/warehouse/insert");
    }
}
