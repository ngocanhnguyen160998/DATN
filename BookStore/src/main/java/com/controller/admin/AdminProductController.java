package com.controller.admin;

import com.dto.ProductDTO;
import com.model.Category;
import com.model.Product;
import com.repository.DataAccess;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DataAccess dataAccess;

    @RequestMapping("/product/table")
    public ModelAndView product(Model model){
        List<ProductDTO> lst = dataAccess.getListProductDTO();
        model.addAttribute("item", lst);
        return new ModelAndView("admin/product/table");
    }

    @RequestMapping("/product/edit")
    public ModelAndView productEdit(@RequestParam(value = "id") Long id, Model model){
        Product product = productService.getById(id).get();
        model.addAttribute("item", product);
        return new ModelAndView("admin/product/edit");
    }

    @RequestMapping("/product/insert")
    public ModelAndView productInsert(Model model){
//        Product product = productService.getById(id).get();
//
        List<Category> lst = categoryService.getAll();
        model.addAttribute("item", lst);
        return new ModelAndView("admin/product/insert");
    }
}
