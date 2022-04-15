package com.service;

import com.model.Orders;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    List<Orders> getAll(Pageable pageable);

    long count();
}
