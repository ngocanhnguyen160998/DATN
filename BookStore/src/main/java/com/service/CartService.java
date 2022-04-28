package com.service;

import com.model.Cart;

public interface CartService {
    void deleteByProductIdAndUserId(Long productId, Long userId);

    Cart insert(Cart cart);

    Cart findByProductIdAndUserId(Long productId, Long userId);
}
