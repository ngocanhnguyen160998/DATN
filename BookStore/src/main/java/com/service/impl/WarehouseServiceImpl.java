package com.service.impl;

import com.dto.WarehouseDTO;
import com.model.Product;
import com.model.Warehouse;
import com.repository.WarehouseRepository;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<Warehouse> getById(Long id) {
        return warehouseRepository.findById(id);
    }

    @Override
    public Warehouse updateById(Long id, WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(id).get();

        if (warehouse == null) {
            return null;
        }

        warehouse.setAmount(warehouseDTO.getAmount());
        warehouse.setNote(warehouseDTO.getNote());

        return warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteById(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public Warehouse insert(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }
}
