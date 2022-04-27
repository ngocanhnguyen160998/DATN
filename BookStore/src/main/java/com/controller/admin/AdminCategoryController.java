package com.controller.admin;

import com.model.Category;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DataAccess dataAccess;

    public String searchInput = "";
    public String message = "";
    public String alert = "";

    @GetMapping("/table")
    public ModelAndView category(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search) {
        PageResponse pageRespone = new PageResponse();
        pageRespone.setLimit(9);
        pageRespone.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 9);
        List<Category> lst;

        if (!"all".equals(search)) {
            lst = dataAccess.getListCategoryByName(searchInput, pageable).getContent();
            pageRespone.setTotalItem(categoryService.countByNameLike(searchInput));
        } else {
            lst = categoryService.getAll(pageable);
            pageRespone.setTotalItem(categoryService.count());
        }
        pageRespone.setTotalPage((int) Math.ceil((double) pageRespone.getTotalItem() / pageRespone.getLimit()));

        model.addAttribute("item", lst);
        model.addAttribute("page", pageRespone);
        model.addAttribute("input", search);
        model.addAttribute("search", new Search());
        model.addAttribute("message", message);
        model.addAttribute("alert", alert);
        message = "";
        alert = "";
        return new ModelAndView("admin/category/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput();
        return new ModelAndView("redirect:/admin/category/table?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
    }

    @GetMapping(value = "/edit")
    public ModelAndView categoryEdit(@RequestParam(value = "id") Long id, Model model) {
        Category find = categoryService.getById(id).get();
        model.addAttribute("item", find);
        model.addAttribute("category", new Category());

        return new ModelAndView("admin/category/edit");
    }

    @PostMapping("/edit")
    public ModelAndView submitFormEdit(@ModelAttribute("category") Category category) {
        try {
            categoryService.updateById(category.getId(), category);
            message = "Thông báo: Chỉnh sửa thông tin thể loại thành công!";
            alert = "success";
        } catch (Exception ex) {
            message = "Thông báo: Chỉnh sửa thông tin thể loại thất bại!";
            alert = "danger";
        }
        return new ModelAndView("redirect:/admin/category/table?page=1&search=all");
    }

    @GetMapping("/insert")
    public ModelAndView categoryInsert(Model model) {
        model.addAttribute("category", new Category());
        return new ModelAndView("admin/category/insert");
    }

    @PostMapping("/insert")
    public ModelAndView submitFormInsert(@ModelAttribute("category") Category category) {
        try {
            categoryService.insert(category);
            message = "Thông báo: Thêm mới thông tin thể loại thành công!";
            alert = "success";
        } catch (Exception ex) {
            message = "Thông báo: Thêm mới thông tin thể loại thất bại!";
            alert = "danger";
        }
        return new ModelAndView("redirect:/admin/category/table?page=1&search=all");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView categoryDelete(@RequestParam(value = "id") Long id) {
        try {
            categoryService.deleteById(id);
            message = "Thông báo: Xóa thông tin thể loại thành công!";
            alert = "success";
        } catch (Exception ex) {
            message = "Thông báo: Xóa thông tin thể loại thất bại!";
            alert = "danger";
        }
        return new ModelAndView("redirect:/admin/category/table?page=1&search=all");
    }
}
