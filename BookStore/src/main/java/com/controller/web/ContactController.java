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
public class ContactController {

    @RequestMapping("/contact")
    public ModelAndView contact(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        model.addAttribute("userSession", user);
        model.addAttribute("search", new Search());
        model.addAttribute("authRequest", new AuthRequest());
        return new ModelAndView("web/contact");
    }
}
