package com.service.impl;

import com.model.WishList;
import com.repository.WishlistRepository;
import com.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public void deleteByProductIdAndUserId(Long productId, Long userId) {
        wishlistRepository.deleteByCondition(productId, userId);
    }

    @Override
    public WishList insert(WishList wishList) {
        return wishlistRepository.save(wishList);
    }

    @Override
    public WishList findByProductIdAndUserId(Long productId, Long userId) {
        return wishlistRepository.findByProductIdAndUserId(productId, userId);
    }
}
