package com.repository;

import com.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.productId = :productId AND c.userId = :userId")
    Integer deleteByCondition(@Param("productId") Long productId, @Param("userId") Long userId);


    Cart findByProductIdAndUserId(Long productId, Long userId);

    List<Cart> findByUserId(Long userId);

    @Query("UPDATE Cart c SET c.status = 1 WHERE c.userId = :userId")
    Cart updateStatus(@Param("userId") Long userId);
}
