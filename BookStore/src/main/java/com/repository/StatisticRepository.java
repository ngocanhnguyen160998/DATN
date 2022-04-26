package com.repository;

import com.model.Statistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    Page<Statistic> findAllByOrderByIdAsc(Pageable pageable);

    @Query("SELECT s FROM Statistic s WHERE s.name LIKE %?1% ORDER BY s.id DESC")
    Page<Statistic> findByNameProduct(String input, Pageable pageable);

    @Query("SELECT count(s.id) FROM Statistic s WHERE s.name LIKE %?1% ORDER BY s.id DESC")
    Long countByNameProduct(String input);

    @Query("SELECT SUM(s.inputMoney) FROM Statistic s")
    Long sumInputMoney();

    @Query("SELECT SUM(s.outputMoney) FROM Statistic s")
    Long sumOutMoney();

    @Query("SELECT SUM(s.profit) FROM Statistic s")
    Long sumProfit();
}
