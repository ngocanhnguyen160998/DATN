package com.controller.admin;

import com.model.StatisticProduct;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.model.response.SearchDate;
import com.service.StatisticProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/statistic-product")
public class AdminStatisticProductController {

    @Autowired
    private StatisticProductService statisticProductService;

    public String searchInput = "";
    public Search search = new Search();


    @GetMapping("/table")
    public ModelAndView statistic(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(9);
        pageResponse.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 9);
        List<StatisticProduct> lst;

        if (!"all".equals(search)) {
            lst = null;
//            if (!"".equals(this.search.getInput()) && "".equals(this.search.getFromDate())) {
//                lst = statisticProductService.getByNameProduct(this.search, pageable);
//                pageResponse.setTotalItem(statisticProductService.countByNameProduct(this.search));
//            } else if (!"".equals(this.search.getFromDate()) && !"".equals(this.search.getToDate()) && "".equals(this.search.getInput())) {
//                lst = statisticProductService.getByDate(this.search, pageable);
//                pageResponse.setTotalItem(statisticProductService.countByDate(this.search));
//            } else {
//                lst = statisticProductService.getByNameProductAndDate(this.search, pageable);
//                pageResponse.setTotalItem(statisticProductService.countByNameProduct(this.search));
//            }
        } else {
            lst = statisticProductService.getAll(pageable);
            pageResponse.setTotalItem(statisticProductService.count());
        }

        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));
        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        model.addAttribute("input", search);
        model.addAttribute("search", new Search());
        return new ModelAndView("admin/statistic_product/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim() + search.getFromDate() + search.getToDate();
        this.search = search;
        return new ModelAndView("redirect:/admin/statistic-product/table?page=1&search=" + ("".equals(searchInput) ? "all" : searchInput));
    }
}
