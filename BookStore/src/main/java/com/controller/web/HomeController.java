package com.controller.web;

import com.model.Product;
import com.model.Role;
import com.model.User;
import com.model.request.AuthRequest;
import com.model.response.Search;
import com.service.ProductService;
import com.service.UserService;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView home(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");

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
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        model.addAttribute("userSession", user);

        return new ModelAndView("web/home");
    }

    @RequestMapping("/contact")
    public ModelAndView contact(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        model.addAttribute("userSession", user);
        model.addAttribute("search", new Search());
        model.addAttribute("authRequest", new AuthRequest());
        return new ModelAndView("web/contact");
    }

    @RequestMapping("/wishlist")
    public ModelAndView wishlist(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user == null) {
            return new ModelAndView("redirect:/account");
        }

        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        return new ModelAndView("web/wishlist");
    }

    @GetMapping("/account")
    public ModelAndView account(Model model, HttpServletRequest request, @RequestParam(value = "action", required = false) String action, @RequestParam(value = "message", required = false) String message) {
        User user = (User) SessionUtil.getSession(request, "USER");

        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        model.addAttribute("user", new User());
        if (!"".equals(message) && message != null) {
            model.addAttribute("message", "Tài khoản hoặc mật khẩu không hợp lệ!");
        }
        return new ModelAndView("web/account");
    }

    @PostMapping("/account")
    public ModelAndView submmitFormAccount(@ModelAttribute("user") User user) {
        try {
            user.setRoleId(100002l);
            userService.insert(user);
            return new ModelAndView("redirect:/");
        } catch (Exception ex) {
            return new ModelAndView("web/account");
        }
    }

    @RequestMapping("/checkout")
    public ModelAndView checkout(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user == null) {
            return new ModelAndView("redirect:/account");
        }

        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        return new ModelAndView("web/checkout");
    }
}
