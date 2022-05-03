package com.controller.web;

import com.dto.CartDTO;
import com.model.*;
import com.model.request.AuthRequest;
import com.model.response.Search;
import com.repository.DataAccess;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private OrdersDetailsService ordersDetailsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private DataAccess dataAccess;

    private Checkout checkout = null;
    private User user = null;
    private Long totalPrice = 0l;

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model, HttpServletRequest request) {
        try {
            User user = (User) SessionUtil.getSession(request, "USER");
            if (user == null) {
                return new ModelAndView("redirect:/account");
            }
            this.user = user;

            List<CartDTO> lstCartAll = dataAccess.getAllListCartByUserId(String.valueOf(user.getId()));
            if (lstCartAll == null || lstCartAll.size() == 0) {
                return new ModelAndView("redirect:/product?page=1");
            }

            model.addAttribute("province", provinceService.findAll());
            if (checkout != null) {
                model.addAttribute("district", districtService.findById(checkout.getProvinceId()));
                model.addAttribute("commune", communeService.findAllByDistrictId(checkout.getDistrictId()));
            }

            Long totalPrice = 0l;
            for (CartDTO cartDTO : lstCartAll) {
                totalPrice += cartDTO.getTotal();
            }

            this.totalPrice = totalPrice;
            model.addAttribute("lstCartAll", lstCartAll);
            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("userSession", user);
            model.addAttribute("authRequest", new AuthRequest());
            model.addAttribute("search", new Search());
            model.addAttribute("checkout", new Checkout());
            return new ModelAndView("web/checkout");
        } catch (Exception e) {
            return new ModelAndView("redirect:/404");
        }
    }

    @PostMapping("/checkout")
    public ModelAndView submmitFormCheckout(@ModelAttribute("checkout") Checkout checkout) {
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

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
            orders.setTotalPrice(totalPrice);
            orders.setPaymentMethod(checkout.getPaymentMethod());
            orders.setUserId(String.valueOf(user.getId()));
            orders.setStatus(0l);
            orders.setModefinedDate(new Date());
            orderService.insert(orders);

            List<Cart> lst = cartService.findByUserId(user.getId());

            String fromDate = dateFormatter.format(orders.getModefinedDate());
            String toDate = dateFormatter.format(System.currentTimeMillis() + 3000);
            System.out.println("LOG TIME GET ORDER: " + fromDate + " - " + toDate);
            Orders tmp = orderService.getByUserIdAndDate(user.getId(), dateFormatter.parse(fromDate), dateFormatter.parse(toDate)).get();

            for (Cart cart : lst) {
                OrdersDetails ordersDetails = new OrdersDetails(cart.getProductId(), tmp.getId(), cart.getTotal() / cart.getAmount(), cart.getAmount());
                cartService.updateStatus(cart);
                ordersDetailsService.insert(ordersDetails);
                warehouseService.minusAmountByProductId(cart.getProductId(), cart.getAmount());
            }

            return new ModelAndView("redirect:/");
        } catch (Exception ex) {
            return new ModelAndView("redirect:/404");
        }
    }
}
