package com.service;

import com.model.StatisticProduct;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StatisticProductService {
    List<StatisticProduct> getAll(Pageable pageable);

    Long count();

}
