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

    @Query("SELECT c FROM Cart c WHERE c.userId = :userId AND c.productId = :productId AND c.status = 0")
    Cart findByProductIdAndUserId(@Param("productId") Long productId, @Param("userId") Long userId);

    @Query("SELECT c FROM Cart c WHERE c.userId = :userId AND c.status = 0")
    List<Cart> findByUserId(@Param("userId") Long userId);

}
