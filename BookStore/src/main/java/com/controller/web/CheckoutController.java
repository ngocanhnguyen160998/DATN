package com.controller.web;

import com.model.User;
import com.model.request.AuthRequest;
import com.model.response.Search;
import com.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckoutController {

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
