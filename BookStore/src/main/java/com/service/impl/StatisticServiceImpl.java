package com.service.impl;

import com.model.Statistic;
import com.repository.StatisticRepository;
import com.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public List<Statistic> getAll(Pageable pageable) {
        return statisticRepository.findAllByOrderByIdAsc(pageable).getContent();
    }

    @Override
    public Long count() {
        return statisticRepository.count();
    }

    @Override
    public List<Statistic> getByNameProduct(String input, Pageable pageable) {
        return statisticRepository.findByNameProduct(input, pageable).getContent();
    }

    @Override
    public Long countByNameProduct(String input) {
        return statisticRepository.countByNameProduct(input);
    }

    @Override
    public Long sumInputMoney() {
        return statisticRepository.sumInputMoney();
    }

    @Override
    public Long sumOutMoney() {
        return statisticRepository.sumOutMoney();
    }

    @Override
    public Long sumProfit() {
        return statisticRepository.sumProfit();
    }
}
