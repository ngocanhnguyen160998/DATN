package com.controller.admin;

import com.dto.ProductDTO;
import com.model.Category;
import com.model.Product;
import com.model.Warehouse;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private WarehouseService warehouseService;

    @Autowired
    private DataAccess dataAccess;

    public String searchInput = "";
    public String message = "";
    public String alert = "";

    @GetMapping("/table")
    public ModelAndView product(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(9);
        pageResponse.setPage(page);

        Pageable pageable = PageRequest.of(page - 1, 9);

        List<ProductDTO> lst;

        if (!"all".equals(search)) {
            lst = dataAccess.getListProductDTOByName(searchInput, pageable, "").getContent();
            pageResponse.setTotalItem(productService.countByNameLike(searchInput));
        } else {
            lst = dataAccess.getListProductDTO(pageable).getContent();
            pageResponse.setTotalItem(productService.count());
        }
        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));

        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        model.addAttribute("input", search);
        model.addAttribute("search", new Search());
        model.addAttribute("message", message);
        model.addAttribute("alert", alert);
        message = "";
        alert = "";
        return new ModelAndView("admin/product/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim();
        return new ModelAndView("redirect:/admin/product/table?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
    }

    @GetMapping(value = "/edit")
    public ModelAndView productEdit(@RequestParam(value = "id") Long id, Model model) {
        Product product = productService.getById(id).get();
        Product p = new Product();
        List<Category> lst = categoryService.getAll();
        Category category = categoryService.getById(product.getCategoryId()).get();
        lst.remove(category);
        model.addAttribute("chooseCategory", category);
        model.addAttribute("categoryItem", lst);
        model.addAttribute("item", product);
        model.addAttribute("product", p);
        return new ModelAndView("admin/product/edit");
    }

    @PostMapping("/edit")
    public ModelAndView submitFormEdit(@ModelAttribute("product") Product product) {
        try {
            productService.updateById(product.getId(), product);
            message = "Thông báo: Chỉnh sửa thông tin sản phẩm thành công!";
            alert = "success";
        } catch (Exception ex) {
            message = "Thông báo: Chỉnh sửa thông tin sản phẩm thất bại!";
            alert = "danger";
        }
        return new ModelAndView("redirect:/admin/product/table?page=1&search=all");
    }

    @GetMapping("/insert")
    public ModelAndView productInsert(Model model) {
        Product p = new Product();
        List<Category> lst = categoryService.getAll();
        model.addAttribute("item", lst);
        model.addAttribute("product", p);
        return new ModelAndView("admin/product/insert");
    }

    @PostMapping("/insert")
    public ModelAndView submitFormInsert(@ModelAttribute("product") Product product) {
        try {
            productService.insert(product);
            Product tmp = productService.getByName(product.getName()).get();
            warehouseService.insert(new Warehouse(tmp.getId(), 999999, 0));
            message = "Thông báo: Thêm mới thông tin sản phẩm thành công!";
            alert = "success";
        } catch (Exception ex) {
            message = "Thông báo: Thêm mới thông tin sản phẩm thất bại!";
            alert = "danger";
        }
        return new ModelAndView("redirect:/admin/product/table?page=1&search=all");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView productDelete(@RequestParam(value = "id") Long id) {
        try {
            productService.deleteById(id);
            message = "Thông báo: Xóa thông tin sản phẩm thành công!";
            alert = "success";
        } catch (Exception ex) {
            message = "Thông báo: Xóa thông tin sản phẩm thất bại!";
            alert = "danger";
        }
        return new ModelAndView("redirect:/admin/product/table?page=1&search=all");
    }
}
