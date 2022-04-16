package com.controller.admin;

import com.dto.UserDTO;
import com.model.Role;
import com.model.User;
import com.model.response.PageResponse;
import com.repository.DataAccess;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataAccess dataAccess;

    @Autowired
    private RoleService roleService;

    @GetMapping("/table")
    public ModelAndView user(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(10);
        pageResponse.setPage(page);


        Pageable pageable = PageRequest.of(page - 1, 10);
        List<UserDTO> lst = dataAccess.getListUserDTO(pageable).getContent();
        pageResponse.setTotalItem(userService.count());
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));


        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        model.addAttribute("search", search);
        return new ModelAndView("admin/user/table");
    }

    @GetMapping(value = "/edit")
    public ModelAndView userEdit(@RequestParam(value = "id") Long id, Model model) {
        List<Role> lst = roleService.getAll();

        User find = userService.getById(id).get();
        Role chooseRole = roleService.getById(find.getRoleId()).get();
        lst.remove(chooseRole);
        model.addAttribute("item", find);
        model.addAttribute("chooseRole", chooseRole);
        model.addAttribute("roleItem", lst);
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
        List<Role> lst = roleService.getAll();
        model.addAttribute("item", lst);
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
