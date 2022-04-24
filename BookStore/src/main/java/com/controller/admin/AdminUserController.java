package com.controller.admin;

import com.dto.UserDTO;
import com.model.Role;
import com.model.User;
import com.model.response.PageResponse;
import com.model.response.Search;
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

    public String searchInput = "";
    public String message = "";

    @GetMapping("/table")
    public ModelAndView user(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(9);
        pageResponse.setPage(page);


        Pageable pageable = PageRequest.of(page - 1, 9);
        List<UserDTO> lst;
        pageResponse.setTotalItem(userService.count());
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

        if (!"all".equals(search)) {
            lst = dataAccess.getListUserDTOByUserName(searchInput, pageable).getContent();
            pageResponse.setTotalItem(userService.countByUserNameLike(searchInput));
        } else {
            lst = dataAccess.getListUserDTO(pageable).getContent();
            pageResponse.setTotalItem(userService.count());
        }
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        model.addAttribute("search", new Search());
        model.addAttribute("input", search);
        model.addAttribute("message", message);
        message = "";
        return new ModelAndView("admin/user/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim();
        return new ModelAndView("redirect:/admin/user/table?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
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
        try {
            userService.updateById(user.getId(), user);
            message = "Thông báo: Chỉnh sửa thông tin người dùng thành công!";
        } catch (Exception ex) {
            message = "Thông báo: Chỉnh sửa thông tin người dùng thất bại!";
        }
        return new ModelAndView("redirect:/admin/user/table?page=1&search=all");
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
        try{
            userService.insert(user);
            message = "Thông báo: Thêm mới thông tin người dùng thành công!";
        } catch (Exception ex) {
            message = "Thông báo: Thêm mới thông tin người dùng thất bại!";
        }
        return new ModelAndView("redirect:/admin/user/table?page=1&search=all");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView userDelete(@RequestParam(value = "id") Long id) {
        try{
            userService.deleteById(id);
            message = "Thông báo: Xóa thông tin người dùng thành công!";
        } catch (Exception ex) {
            message = "Thông báo: Xóa thông tin người dùng thất bại!";
        }
        return new ModelAndView("redirect:/admin/user/table?page=1&search=all");
    }


}
