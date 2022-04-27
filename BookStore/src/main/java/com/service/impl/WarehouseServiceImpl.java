package com.service.impl;

import com.dto.WarehouseDTO;
import com.model.Product;
import com.model.Warehouse;
import com.repository.WarehouseRepository;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public List<Warehouse> getAll(Pageable pageable) {
        return warehouseRepository.findAll(pageable).getContent();
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

        if (warehouse.getInputAmount() < warehouseDTO.getInputAmount()) {
            warehouse.setAmount(warehouse.getAmount() + (warehouseDTO.getInputAmount() - warehouse.getInputAmount()));
        } else if (warehouse.getInputAmount() > warehouseDTO.getInputAmount()) {
            warehouse.setAmount(warehouse.getAmount() - (warehouse.getInputAmount() - warehouseDTO.getInputAmount()));
        } else {
            warehouse.setAmount(warehouse.getAmount());
        }
        if (warehouse.getAmount() < 0) {
            warehouse.setAmount(null);
        }

        warehouse.setInputAmount(warehouseDTO.getInputAmount());
        warehouse.setInputPrice(warehouseDTO.getInputPrice());
        warehouse.setNote(warehouseDTO.getNote());


        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse inputWarehouseById(Long id, WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(id).get();
        if (warehouse == null) {
            return null;
        }
        warehouse.setAmount(warehouse.getAmount() + warehouseDTO.getInputAmount());
        warehouse.setInputAmount(warehouse.getInputAmount() + warehouseDTO.getInputAmount());
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteById(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public Warehouse insert(Warehouse warehouse) {
        warehouse.setAmount(warehouse.getInputAmount());
        return warehouseRepository.save(warehouse);
    }

    @Override
    public long count() {
        return warehouseRepository.count();
    }

    @Override
    public long countByLikeNameProduct(String name) {
        return warehouseRepository.countByNameLike(name);
    }

    @Override
    public Optional<Warehouse> getByProductId(Long productId) {
        return warehouseRepository.findByProductId(productId);
    }

    @Override
    public Warehouse updateAmountByProductId(Long id, int amountAdd) {
        Warehouse warehouse = warehouseRepository.findByProductId(id).get();

        if (warehouse == null) {
            return null;
        }

        warehouse.setAmount(warehouse.getAmount() + amountAdd);
        warehouse.setInputAmount(warehouse.getInputAmount());
        warehouse.setInputPrice(warehouse.getInputPrice());
        warehouse.setNote(warehouse.getNote());
        return warehouse;
    }
}
