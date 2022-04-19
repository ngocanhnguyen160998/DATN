package com.controller.web;

import com.dto.ProductDTO;
import com.model.response.PageResponse;
import com.repository.DataAccess;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DataAccess dataAccess;

    @GetMapping("/product")
    public ModelAndView product(Model model, @RequestParam("category-id") int categoryId, @RequestParam("page") int page) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(9);
        pageResponse.setPage(page);

        Pageable pageable = PageRequest.of(page - 1, 9);

        List<ProductDTO> lst = dataAccess.getListProductDTO(pageable).getContent();
        pageResponse.setTotalItem(productService.count());
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

        model.addAttribute("item", lst);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("page", pageResponse);
        return new ModelAndView("web/product");
    }
}
