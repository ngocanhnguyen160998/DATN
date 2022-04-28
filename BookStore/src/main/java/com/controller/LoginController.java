package com.controller;

import com.model.User;
import com.model.request.AuthRequest;
import com.util.Authen;
import com.util.SessionUtil;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private Authen authen;

    @GetMapping("/login")
    public ModelAndView login(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");

        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        return new ModelAndView("web/login_modal");
    }

    @PostMapping("/login")
    public ModelAndView submitFormlogin(@ModelAttribute("authRequest") AuthRequest authRequest, HttpServletRequest request) {
        String url = "";
        try {
            url = authen.auth(authRequest, request);
            if("".equals(url)) {
                return new ModelAndView("redirect:/account?action=login&message=wrong_account_or_password");
            }
        } catch (ObjectNotFoundException | NullPointerException e) {
            return new ModelAndView("redirect:/account?action=login&message=wrong_account_or_password");
        }
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user != null) {
            SessionUtil.removeSession(request, "USER");
        }
        return new ModelAndView("redirect:/");
    }
}
