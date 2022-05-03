package com.controller.web;

import com.model.*;
import com.model.request.AuthRequest;
import com.model.response.Search;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.WarehouseService;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private WarehouseService warehouseService;

    private Long productId = 0l;

    @GetMapping("/product-detail")
    public ModelAndView product(Model model, HttpServletRequest request, @RequestParam("id") Long id) {
        try {
            User user = (User) SessionUtil.getSession(request, "USER");
            Product product = productService.getById(id).get();
            Category category = categoryService.getById(product.getCategoryId()).get();
            Warehouse warehouse = warehouseService.getByProductId(product.getId()).orElse(new Warehouse(0));
            List<Product> productRelated = productService.get8ProductRandomByCategory(String.valueOf(product.getCategoryId()), String.valueOf(product.getId()));

            productId = id;
            model.addAttribute("userSession", user);
            model.addAttribute("item", product);
            model.addAttribute("category", category);
            model.addAttribute("warehouse", warehouse);
            model.addAttribute("productRelated", productRelated);
            model.addAttribute("authRequest", new AuthRequest());
            model.addAttribute("search", new Search());
            model.addAttribute("ordersDetails", new OrdersDetails());
            return new ModelAndView("web/product_detail");
        } catch (Exception e) {
            return new ModelAndView("redirect:/404");
        }
    }

    @PostMapping("/product-detail")
    public ModelAndView submmitFormProductDetail(@ModelAttribute("ordersDetails") OrdersDetails ordersDetails) {
        try {
            return new ModelAndView("redirect:/cart?id=" + productId + "&amount=" + ordersDetails.getAmount() + "&action=insert");
        } catch (Exception ex) {
            return new ModelAndView("redirect:/404");
        }
    }
}
