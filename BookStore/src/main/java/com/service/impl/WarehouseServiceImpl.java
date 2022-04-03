package com.service.impl;

import com.model.Warehouse;
import com.repository.WarehouseRepository;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }
}
