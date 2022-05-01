package com.service;

import com.model.Cart;

import java.util.List;

public interface CartService {
    void deleteByProductIdAndUserId(Long productId, Long userId);

    Cart insert(Cart cart);

    Cart findByProductIdAndUserId(Long productId, Long userId);

    Cart updateStatus(Cart cart);

    List<Cart> findByUserId(Long userId);
}
