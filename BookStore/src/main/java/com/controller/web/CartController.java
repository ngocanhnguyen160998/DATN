package com.controller.web;

import com.dto.CartDTO;
import com.dto.WishlistDTO;
import com.model.*;
import com.model.request.AuthRequest;
import com.model.response.PageResponse;
import com.model.response.Search;
import com.repository.DataAccess;
import com.service.CartService;
import com.service.ProductService;
import com.service.WarehouseService;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private WarehouseService warehouseService;

    @Autowired
    private DataAccess dataAccess;

    private String message = "";

    @GetMapping("/cart")
    public ModelAndView cart(Model model, HttpServletRequest request,
                             @RequestParam(value = "id", required = false) String id,
                             @RequestParam(value = "amount", required = false) String amount,
                             @RequestParam(value = "action", required = false) String action) {
        try {
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
                    Warehouse warehouse = warehouseService.getByProductId(Long.parseLong(id)).orElse(null);
                    if (warehouse != null) {
                        if (warehouse.getAmount() >= Integer.parseInt(amount)) {
                            cartService.insert(new Cart(Integer.parseInt(amount), Long.parseLong(id), user.getId(), totalPrice, 0));
                        } else {
                            message = "Dữ liệu nhập không hợp lệ, vui lòng nhập lại!";
                        }
                    } else {
                        message = "Sản phẩm tạm hết hàng!";
                    }
                }
            } else if ("delete".equals(action)) {
                cartService.deleteByProductIdAndUserId(Long.parseLong(id), user.getId());
            }

            List<CartDTO> lstAll = dataAccess.getAllListCartByUserId(String.valueOf(user.getId()));
            Long totalPrice = 0l;
            int tmp = 1;
            for(CartDTO cartDTO : lstAll) {
                String index = request.getParameter("index" + tmp);
                if (index != null) {
                    cartService.updateAmount(cartDTO.getProductId(), user.getId(), Integer.parseInt(index));
                }
                tmp++;
            }

            lstAll = dataAccess.getAllListCartByUserId(String.valueOf(user.getId()));
            for(CartDTO cartDTO : lstAll) {
                totalPrice += cartDTO.getTotal();
            }

            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("item", lstAll);
            model.addAttribute("userSession", user);
            model.addAttribute("authRequest", new AuthRequest());
            model.addAttribute("search", new Search());
            model.addAttribute("message", message);
            message = "";
            return new ModelAndView("web/cart");
        } catch (Exception e) {
            return new ModelAndView("redirect:/404");
        }
    }

}
