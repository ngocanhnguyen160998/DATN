package com.controller.web;

import com.dto.CartDTO;
import com.dto.WishlistDTO;
import com.model.Cart;
import com.model.Product;
import com.model.User;
import com.model.WishList;
import com.model.request.AuthRequest;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.CartService;
import com.service.ProductService;
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
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DataAccess dataAccess;

    @GetMapping("/cart")
    public ModelAndView cart(Model model, HttpServletRequest request,
                             @RequestParam("page") int page,
                             @RequestParam(value = "id", required = false) String id,
                             @RequestParam(value = "amount", required = false) String amount,
                             @RequestParam(value = "action", required = false) String action) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user == null) {
            return new ModelAndView("redirect:/account");
        }



        if ("insert".equals(action)) {
            Product product = productService.getById(Long.parseLong(id)).get();
            Long price = product.getPrice();
            if (product.getSalePrice() < product.getPrice() && product.getSalePrice() != 0) {
                price = product.getSalePrice();
            }
            Long totalPrice = price * Long.parseLong(amount);
            if (cartService.findByProductIdAndUserId(Long.parseLong(id), user.getId()) == null) {
                cartService.insert(new Cart(Integer.parseInt(amount), Long.parseLong(id), user.getId(), totalPrice, 0));
            }
        } else if ("delete".equals(action)) {
            cartService.deleteByProductIdAndUserId(Long.parseLong(id), user.getId());
        }

        PageResponse pageRespone = new PageResponse();
        pageRespone.setLimit(3);
        pageRespone.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, 3);

        List<CartDTO> lst = dataAccess.getListCartByUserId(String.valueOf(user.getId()), pageable).getContent();
        List<CartDTO> lstAll = dataAccess.getAllListCartByUserId(String.valueOf(user.getId()));
        pageRespone.setTotalItem(dataAccess.countCartByUserId(String.valueOf(user.getId())));
        pageRespone.setTotalPage((int) Math.ceil((double) pageRespone.getTotalItem() / pageRespone.getLimit()));

        Long totalPrice = 0l;
        for(CartDTO cartDTO : lstAll) {
            totalPrice += cartDTO.getTotal();
        }

        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("item", lst);
        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        model.addAttribute("page", pageRespone);
        return new ModelAndView("web/cart");
    }
}
