package com.service;

import com.model.Orders;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> getAll(Pageable pageable);

    long count();

    Orders updateConfirmById(Long id);

    Orders updateCancelById(Long id);

    Orders updateFinishById(Long id);

    long countByFullNameAndPhone(String input);

    List<Orders> getByFullNameAndPhone(String input, Pageable pageable);

    Optional<Orders> getById(Long id);

    Orders insert(Orders orders);

    Optional<Orders> getByUserIdAndDate(Long userId, Date fromDate, Date toDate);
}
