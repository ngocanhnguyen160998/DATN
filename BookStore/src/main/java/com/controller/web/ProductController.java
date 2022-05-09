package com.controller.web;

import com.dto.ProductDTO;
import com.model.Category;
import com.model.User;
import com.model.request.AuthRequest;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.CategoryService;
import com.service.ProductService;
import com.util.SessionUtil;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DataAccess dataAccess;

    public String searchInput = "";

    @GetMapping("/product")
    public ModelAndView product(Model model, HttpServletRequest request,
                                @RequestParam(value = "category-id", required = false) String categoryId,
                                @RequestParam(value = "search", required = false) String search,
                                @RequestParam("page") int page,
                                @RequestParam(value = "sort", required = false) String sortPrice) {
        try {
            User user = (User) SessionUtil.getSession(request, "USER");
            PageResponse pageResponse = new PageResponse();
            pageResponse.setLimit(9);
            pageResponse.setPage(page);

            Pageable pageable = PageRequest.of(page - 1, 9);

            List<ProductDTO> lst;
            List<Category> lstCategory = categoryService.getAll();

            if ("hot".equals(categoryId)) {
                lst = dataAccess.getListProductDTOByTypeHot(pageable, sortPrice).getContent();
                pageResponse.setTotalItem(productService.countByProductHot());
            } else if ("sale".equals(categoryId)) {
                lst = dataAccess.getListProductDTOByTypeSale(pageable, sortPrice).getContent();
                pageResponse.setTotalItem(productService.countByProductSale());
            } else if ("new".equals(categoryId)) {
                lst = dataAccess.getListProductDTOByTypeNew(pageable, sortPrice).getContent();
                pageResponse.setTotalItem(productService.count());
            } else {
                if (!"all".equals(search) && search != null) {
                    lst = dataAccess.getListProductDTOByName(searchInput, pageable, sortPrice).getContent();
                    pageResponse.setTotalItem(productService.countByNameLike(searchInput));
                } else {
                    lst = dataAccess.getListProductDTOByCategoryId(pageable, categoryId, sortPrice).getContent();
                    if (categoryId != null && !"".equals(categoryId)) {
                        pageResponse.setTotalItem(productService.countByCategoryId(categoryId));
                    } else {
                        pageResponse.setTotalItem(productService.count());
                    }
                }
            }

            pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

            model.addAttribute("sortPrice", sortPrice);
            model.addAttribute("userSession", user);
            model.addAttribute("authRequest", new AuthRequest());
            model.addAttribute("item", lst);
            model.addAttribute("itemCategory", lstCategory);
            model.addAttribute("search", new Search());
            model.addAttribute("categoryId", categoryId);
            model.addAttribute("page", pageResponse);
            return new ModelAndView("web/product");
        } catch (Exception e) {
            return new ModelAndView("redirect:/404");
        }
    }

    @PostMapping("/product")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim();
        return new ModelAndView("redirect:/product?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
    }
}
