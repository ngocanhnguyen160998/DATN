package com.controller.admin;

import com.model.Category;
import com.model.response.PageResponse;
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

    @GetMapping("/table")
    public ModelAndView category(Model model, @RequestParam("page") int page) {
        PageResponse pageRespone = new PageResponse();
        pageRespone.setLimit(10);
        pageRespone.setPage(page);
        pageRespone.setTotalItem(categoryService.count());
        pageRespone.setTotalPage((int) Math.ceil((double) pageRespone.getTotalItem() / pageRespone.getLimit()));

        Pageable pageable = PageRequest.of(page - 1, 10);
        List<Category> lst = categoryService.getAll(pageable);

        model.addAttribute("item", lst);
        model.addAttribute("page", pageRespone);
        return new ModelAndView("admin/category/table");
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
        categoryService.updateById(category.getId(), category);
        return new ModelAndView("redirect:/admin/category/table");
    }

    @GetMapping("/insert")
    public ModelAndView categoryInsert(Model model) {
        model.addAttribute("category", new Category());
        return new ModelAndView("admin/category/insert");
    }

    @PostMapping("/insert")
    public ModelAndView submitFormInsert(@ModelAttribute("category") Category category) {
        categoryService.insert(category);
        return new ModelAndView("redirect:/admin/category/table");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView categoryDelete(@RequestParam(value = "id") Long id) {
        categoryService.deleteById(id);
        return new ModelAndView("redirect:/admin/category/table");
    }
}
