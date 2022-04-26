package com.controller.web;

import com.dto.ProductDTO;
import com.model.Category;
import com.model.Product;
import com.model.Warehouse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("/product-detail")
    public ModelAndView product(Model model, @RequestParam("id") Long id) {
        Product product = productService.getById(id).get();
        Category category = categoryService.getById(product.getCategoryId()).get();
        Warehouse warehouse = warehouseService.getByProductId(product.getId()).get();
        List<Product> productRelated = productService.get8ProductRandomByCategory(String.valueOf(product.getCategoryId()), String.valueOf(product.getId()));
        model.addAttribute("item", product);
        model.addAttribute("category", category);
        model.addAttribute("warehouse", warehouse);
        model.addAttribute("productRelated", productRelated);
        model.addAttribute("search", new Search());
        return new ModelAndView("web/product_detail");
    }
}
