package com.controller.web;

import com.model.User;
import com.model.request.AuthRequest;
import com.model.request.Checkout;
import com.model.response.Search;
import com.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user == null) {
            return new ModelAndView("redirect:/account");
        }

        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        model.addAttribute("checkout", new CheckoutController());
        return new ModelAndView("web/checkout");
    }

    @PostMapping("/account")
    public ModelAndView submmitFormCheckout(@ModelAttribute("checkout") Checkout checkout) {
        try {
            System.out.println(checkout.toString());
            return new ModelAndView("redirect:/");
        } catch (Exception ex) {
            return new ModelAndView("web/account");
        }
    }
}
