package com.controller.admin;

import com.model.Orders;
import com.model.Statistic;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.model.response.SearchDate;
import com.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/statistic")
public class AdminStatisticController {

    @Autowired
    private StatisticService statisticService;

    public String searchInput = "";

    @GetMapping("/table")
    public ModelAndView statistic(Model model, @RequestParam("page") int page, @RequestParam(value = "search", required = false) String search){
        PageResponse pageResponse = new PageResponse();
        pageResponse.setLimit(9);
        pageResponse.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 9);
        List<Statistic> lst;

        if (!"all".equals(search)) {
            lst = statisticService.getByNameProduct(searchInput, pageable);
            pageResponse.setTotalItem(statisticService.countByNameProduct(searchInput));
        } else {
            lst = statisticService.getAll(pageable);
            pageResponse.setTotalItem(statisticService.count());
        }

        pageResponse.setTotalPage((int) Math.ceil((double) pageResponse.getTotalItem() / pageResponse.getLimit()));
        model.addAttribute("item", lst);
        model.addAttribute("page", pageResponse);
        model.addAttribute("input", search);
        model.addAttribute("search", new Search());
        return new ModelAndView("admin/statistic/table");
    }

    @PostMapping("/table")
    public ModelAndView submitFormSearch(@ModelAttribute("search") Search search) {
        searchInput = search.getInput().trim();
        return new ModelAndView("redirect:/admin/statistic/table?page=1&search=" + ("".equals(search.getInput().trim()) ? "all" : search.getInput().trim()));
    }
}
