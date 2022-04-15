package com.service.impl;

import com.model.Orders;
import com.repository.OrderRepository;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable).getContent();
    }

    @Override
    public long count() {
        return orderRepository.count();
    }
}
