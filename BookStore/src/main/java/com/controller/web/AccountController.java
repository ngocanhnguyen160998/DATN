package com.controller.web;

import com.model.User;
import com.model.request.AuthRequest;
import com.model.response.Search;
import com.service.UserService;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    private UserService userService;

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
}
