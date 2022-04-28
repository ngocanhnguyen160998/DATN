package com.service;

import com.model.WishList;

public interface WishlistService {
    void deleteByProductIdAndUserId(Long productId, Long userId);

    WishList insert(WishList wishList);

    WishList findByProductIdAndUserId(Long productId, Long userId);
}
