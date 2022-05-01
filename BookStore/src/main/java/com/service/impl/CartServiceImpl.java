package com.service.impl;

import com.model.Cart;
import com.repository.CartRepository;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void deleteByProductIdAndUserId(Long productId, Long userId) {
        cartRepository.deleteByCondition(productId, userId);
    }

    @Override
    public Cart insert(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart findByProductIdAndUserId(Long productId, Long userId) {
        return cartRepository.findByProductIdAndUserId(productId, userId);
    }

    @Override
    public Cart updateStatus(Cart cart) {
        cart.setStatus(1);
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> findByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}
