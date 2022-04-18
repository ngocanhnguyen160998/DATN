package com.service;

import com.model.Orders;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> getAll(Pageable pageable);

    long count();

    Orders updateById(Long id);

    long countByFullNameAndPhone(String input);

    List<Orders> getByFullNameAndPhone(String input, Pageable pageable);

    Optional<Orders> getById(Long id);
}
