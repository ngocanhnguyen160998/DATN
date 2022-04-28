package com.repository;

import com.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface WishlistRepository extends JpaRepository<WishList, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM WishList w WHERE w.productId = :productId AND w.userId = :userId")
    Integer deleteByCondition(@Param("productId") Long productId, @Param("userId") Long userId);


    WishList findByProductIdAndUserId(Long productId, Long userId);
}
