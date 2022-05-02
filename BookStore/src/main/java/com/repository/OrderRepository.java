package com.repository;

import com.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    Page<Orders> findAllByOrderByIdDesc(Pageable pageable);

    @Query("SELECT count(o.id) FROM Orders o WHERE concat(o.firstName, ' ',o.lastName, o.phone) LIKE %?1%")
    Long countByFullNameAndPhone(@Param("input") String input);

    @Query("SELECT o FROM Orders o WHERE concat(o.firstName, ' ',o.lastName, o.phone) LIKE %?1% ORDER BY o.id DESC")
    Page<Orders> findByFullNameAndPhone(String input, Pageable pageable);

    @Query("SELECT o FROM Orders o WHERE o.userId = :userId AND o.modefinedDate >= :fromDate AND o.modefinedDate <= :toDate")
    Optional<Orders> findByUserIdAndDate(@Param("userId") String userId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
