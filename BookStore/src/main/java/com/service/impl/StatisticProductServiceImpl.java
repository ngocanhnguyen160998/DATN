package com.service.impl;

import com.model.StatisticProduct;
import com.repository.StatisticProductRepository;
import com.service.StatisticProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticProductServiceImpl implements StatisticProductService {

    @Autowired
    private StatisticProductRepository statisticProductRepository;

    @Override
    public List<StatisticProduct> getAll(Pageable pageable) {
        return statisticProductRepository.findAllByOrderByIdAsc(pageable).getContent();
    }

    @Override
    public Long count() {
        return statisticProductRepository.count();
    }
}
