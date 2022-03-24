package com.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home(Model model){

        return new ModelAndView("web/home");
    }

    @RequestMapping("/contact")
    public ModelAndView contact(Model model){

        return new ModelAndView("web/contact");
    }

    @RequestMapping("/about")
    public ModelAndView about(){

        return new ModelAndView("web/about");
    }

    @RequestMapping("/services")
    public ModelAndView services(){

        return new ModelAndView("web/services");
    }
}
