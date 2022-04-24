package com.service;

import com.model.Statistic;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StatisticService {
    List<Statistic> getAll(Pageable pageable);

    Long count();

    List<Statistic> getByNameProduct(String input, Pageable pageable);

    Long countByNameProduct(String input);
}
