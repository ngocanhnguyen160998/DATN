package com.controller.admin;

import com.dto.UserDTO;
import com.model.User;
import com.repository.DataAccess;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataAccess dataAccess;

    @RequestMapping("/table")
    public ModelAndView user(Model model) {
        List<UserDTO> lst = dataAccess.getListUserDTO();
        model.addAttribute("item", lst);
        return new ModelAndView("admin/user/table");
    }

    @GetMapping(value = "/edit")
    public ModelAndView userEdit(@RequestParam(value = "id") Long id, Model model) {


        User find = userService.getById(id).get();
        model.addAttribute("item", find);
        model.addAttribute("user", new User());
        return new ModelAndView("admin/user/edit");
    }

    @PostMapping("/edit")
    public ModelAndView submitFormEdit(@ModelAttribute("user") User user) {
        userService.updateById(user.getId(), user);
        return new ModelAndView("redirect:/admin/user/table");
    }

    @GetMapping("/insert")
    public ModelAndView userInsert(Model model) {

        model.addAttribute("user", new User());
        return new ModelAndView("admin/user/insert");
    }

    @PostMapping("/insert")
    public ModelAndView submitFormInsert(@ModelAttribute("user") User user) {
        userService.insert(user);
        return new ModelAndView("redirect:/admin/user/table");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView userDelete(@RequestParam(value = "id") Long id) {
        userService.deleteById(id);
        return new ModelAndView("redirect:/admin/user/table");
    }
}
