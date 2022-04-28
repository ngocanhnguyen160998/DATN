package com.controller.web;

import com.dto.WishlistDTO;
import com.model.Product;
import com.model.User;
import com.model.Warehouse;
import com.model.WishList;
import com.model.request.AuthRequest;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.ProductService;
import com.service.WarehouseService;
import com.service.WishlistService;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private DataAccess dataAccess;

    @GetMapping("/wishlist")
    public ModelAndView wishlist(Model model, HttpServletRequest request,
                                 @RequestParam("page") int page,
                                 @RequestParam(value = "id", required = false) String id,
                                 @RequestParam(value = "action", required = false) String action) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user == null) {
            return new ModelAndView("redirect:/account");
        }

        if ("insert".equals(action)) {
            if (wishlistService.findByProductIdAndUserId(Long.parseLong(id), user.getId()) == null) {
                wishlistService.insert(new WishList(Long.parseLong(id), user.getId()));
            }
        } else if ("delete".equals(action)) {
            wishlistService.deleteByProductIdAndUserId(Long.parseLong(id), user.getId());
        }

        PageResponse pageRespone = new PageResponse();
        pageRespone.setLimit(3);
        pageRespone.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 3);

        List<WishlistDTO> lst = dataAccess.getListWishlistByUserId(String.valueOf(user.getId()), pageable).getContent();
        pageRespone.setTotalItem(dataAccess.countWishlistByUserId(String.valueOf(user.getId())));
        pageRespone.setTotalPage((int) Math.ceil((double) pageRespone.getTotalItem() / pageRespone.getLimit()));

        model.addAttribute("item", lst);
        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        model.addAttribute("page", pageRespone);
        return new ModelAndView("web/wishlist");
    }

}
