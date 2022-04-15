package com.controller.admin;

import com.dto.ProductDTO;
import com.model.Category;
import com.model.Product;
import com.model.response.PageResponse;
import com.repository.DataAccess;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DataAccess dataAccess;

    @GetMapping("/table")
    public ModelAndView product(Model model, @RequestParam("page") int page){
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(10);
        pageResponse.setPage(page);
        pageResponse.setTotalItem(productService.count());
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));
        Pageable pageable = PageRequest.of(page - 1, 10);

        List<ProductDTO> lst = dataAccess.getListProductDTO(pageable).getContent();

        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        return new ModelAndView("admin/product/table");
    }

    @GetMapping(value = "/edit")
    public ModelAndView productEdit(@RequestParam(value = "id") Long id, Model model){
        Product product = productService.getById(id).get();
        Product p = new Product();
        List<Category> lst = categoryService.getAll();
        Category category = categoryService.getById(product.getCategoryId()).get();
        lst.remove(category);
        model.addAttribute("chooseCategory",category);
        model.addAttribute("categoryItem", lst);
        model.addAttribute("item", product);
        model.addAttribute("product",p);
        return new ModelAndView("admin/product/edit");
    }

    @PostMapping("/edit")
    public ModelAndView submitFormEdit(@ModelAttribute("product") Product product){
        productService.updateById(product.getId(), product);
        return new ModelAndView("redirect:/admin/product/table");
    }

    @GetMapping("/insert")
    public ModelAndView productInsert(Model model){
        Product p = new Product();
        List<Category> lst = categoryService.getAll();
        model.addAttribute("item", lst);
        model.addAttribute("product",p);
        return new ModelAndView("admin/product/insert");
    }

    @PostMapping("/insert")
    public ModelAndView submitFormInsert(@ModelAttribute("product") Product product){
        productService.insert(product);
        return new ModelAndView("redirect:/admin/product/table");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView productDelete(@RequestParam(value = "id") Long id){
        productService.deleteById(id);
        return new ModelAndView("redirect:/admin/product/table");
    }
}
