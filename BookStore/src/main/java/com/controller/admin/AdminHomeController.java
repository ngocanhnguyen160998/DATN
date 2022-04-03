package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @RequestMapping("/home")
    public ModelAndView home(Model model){
//        model.addAttribute("name", name);
        return new ModelAndView("admin/home");
    }



}
