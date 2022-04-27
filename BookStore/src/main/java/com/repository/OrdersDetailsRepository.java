package com.repository;

import com.model.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrdersDetails, Long> {

    @Query(value = "SELECT * FROM orders_details WHERE order_id = :orderId", nativeQuery = true)
    List<OrdersDetails> findAllByOrderId(@Param("orderId") Long id);
}
