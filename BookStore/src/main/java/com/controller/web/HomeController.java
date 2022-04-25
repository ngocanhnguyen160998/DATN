package com.controller.web;

import com.model.Product;
import com.model.Role;
import com.model.User;
import com.model.response.Search;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView home(Model model){

        List<Product> lstProductSale = productService.get8ProductSale();
        List<Product> lstProductNew = productService.get8ProductNew();
        List<Product> lstProductHot = productService.get8ProductHot();
        List<Product> lstProductVanHoc = productService.get8ProductByCategory("100001");
        List<Product> lstProductKinhTe = productService.get8ProductByCategory("100002");
        List<Product> lstProductKyNangSong = productService.get8ProductByCategory("100003");
        List<Product> lstProductGiaoDuc = productService.get8ProductByCategory("100004");

        model.addAttribute("lstProductSale", lstProductSale);
        model.addAttribute("lstProductNew", lstProductNew);
        model.addAttribute("lstProductHot", lstProductHot);
        model.addAttribute("lstProductVanHoc", lstProductVanHoc);
        model.addAttribute("lstProductKyNangSong", lstProductKyNangSong);
        model.addAttribute("lstProductGiaoDuc", lstProductGiaoDuc);
        model.addAttribute("lstProductKinhTe", lstProductKinhTe);
        model.addAttribute("search", new Search());
        return new ModelAndView("web/home");
    }

    @RequestMapping("/contact")
    public ModelAndView contact(Model model){
        model.addAttribute("search", new Search());
        return new ModelAndView("web/contact");
    }

    @RequestMapping("/wishlist")
    public ModelAndView wishlist(Model model){
        model.addAttribute("search", new Search());
        return new ModelAndView("web/wishlist");
    }

    @GetMapping("/account")
    public ModelAndView account(Model model){
        model.addAttribute("search", new Search());
        model.addAttribute("user", new User());
        return new ModelAndView("web/account");
    }

    @PostMapping("/account")
    public ModelAndView submmitFormAccount(@ModelAttribute("user") User user){
        try{
            user.setRoleId(2l);
            userService.insert(user);
        } catch (Exception ex) {

        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/checkout")
    public ModelAndView checkout(Model model){
        model.addAttribute("search", new Search());
        return new ModelAndView("web/checkout");
    }
}
