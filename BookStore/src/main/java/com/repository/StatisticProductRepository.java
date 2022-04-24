package com.repository;

import com.model.StatisticProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatisticProductRepository extends JpaRepository<StatisticProduct, Long> {
    Page<StatisticProduct> findAllByOrderByIdAsc(Pageable pageable);
}
