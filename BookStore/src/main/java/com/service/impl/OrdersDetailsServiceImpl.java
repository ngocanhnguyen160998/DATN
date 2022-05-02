package com.service.impl;

import com.model.OrdersDetails;
import com.repository.OrdersDetailsRepository;
import com.service.OrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailsServiceImpl implements OrdersDetailsService {

    @Autowired
    private OrdersDetailsRepository ordersDetailsRepository;

    @Override
    public List<OrdersDetails> getAllByOrderId(Long id) {
        return ordersDetailsRepository.findAllByOrderId(id);
    }

    @Override
    public OrdersDetails insert(OrdersDetails ordersDetails) {
        return ordersDetailsRepository.save(ordersDetails);
    }
}
