package com.service;

import com.model.OrdersDetails;

import java.util.List;

public interface OrdersDetailsService {

    List<OrdersDetails> getAllByOrderId(Long id);
}
