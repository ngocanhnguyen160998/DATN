package com.controller.web;

import com.model.Cart;
import com.model.Orders;
import com.model.User;
import com.model.request.AuthRequest;
import com.model.Checkout;
import com.model.response.Search;
import com.service.*;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CommuneService communeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    private Checkout checkout = null;
    private User user = null;

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model, HttpServletRequest request) {
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user == null) {
            return new ModelAndView("redirect:/account");
        }
        this.user = user;

        model.addAttribute("province", provinceService.findAll());
        if (checkout != null) {
            model.addAttribute("district", districtService.findById(checkout.getProvinceId()));
            model.addAttribute("commune", communeService.findAllByDistrictId(checkout.getDistrictId()));
        }
        model.addAttribute("userSession", user);
        model.addAttribute("authRequest", new AuthRequest());
        model.addAttribute("search", new Search());
        model.addAttribute("checkout", new Checkout());
        return new ModelAndView("web/checkout");
    }

    @PostMapping("/checkout")
    public ModelAndView submmitFormCheckout(@ModelAttribute("checkout") Checkout checkout) {
        try {
            this.checkout = checkout;
            String provinceName = provinceService.findAll().get(checkout.getProvinceId());
            String districtName = districtService.findAll().get(checkout.getDistrictId());
            String communeName = communeService.findAll().get(checkout.getCommuneId());

            Orders orders = new Orders();
            orders.setFirstName(checkout.getFirstName());
            orders.setLastName(checkout.getLastName());
            orders.setEmail(checkout.getEmail());
            orders.setPhone(checkout.getPhone());
            orders.setAddress(checkout.getAddress());
            orders.setProvince(provinceName);
            orders.setDistrict(districtName);
            orders.setCommune(communeName);
            orders.setSpecialNotes(checkout.getNote());
            orders.setModefinedDate(new Date());
//            orders.setTotalPrice(0l);
            orders.setPaymentMethod("");
            orders.setUserId(String.valueOf(user.getId()));
            orders.setStatus(0l);

            List<Cart> lst = cartService.findByUserId(user.getId());
            for (Cart cart : lst) {
                cartService.updateStatus(cart);
            }

            orderService.insert(orders);
            return new ModelAndView("redirect:/");
        } catch (Exception ex) {
            return new ModelAndView("web/account");
        }
    }
}
