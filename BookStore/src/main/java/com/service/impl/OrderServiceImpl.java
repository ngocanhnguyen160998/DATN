package com.service.impl;

import com.model.Orders;
import com.repository.OrderRepository;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> getAll(Pageable pageable) {
        return orderRepository.findAllByOrderByIdDesc(pageable).getContent();
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public Orders updateFinishById(Long id) {
        Orders tmp = orderRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setStatus(3l);
        return orderRepository.save(tmp);
    }

    @Override
    public Orders updateConfirmById(Long id) {
        Orders tmp = orderRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setStatus(1l);
        return orderRepository.save(tmp);
    }

    @Override
    public Orders updateCancelById(Long id) {
        Orders tmp = orderRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setStatus(2l);
        return orderRepository.save(tmp);
    }

    @Override
    public long countByFullNameAndPhone(String input) {
        return orderRepository.countByFullNameAndPhone(input);
    }

    @Override
    public List<Orders> getByFullNameAndPhone(String input, Pageable pageable) {
        return orderRepository.findByFullNameAndPhone(input, pageable).getContent();
    }

    @Override
    public Optional<Orders> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders insert(Orders orders) {
        return orderRepository.save(orders);
    }
}
