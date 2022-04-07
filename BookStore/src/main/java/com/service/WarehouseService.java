package com.service;

import com.dto.WarehouseDTO;
import com.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    List<Warehouse> getAll();

    Optional<Warehouse> getById(Long id);

    Warehouse updateById(Long id, WarehouseDTO warehouseDTO);

    void deleteById(Long id);

    Warehouse insert(Warehouse warehouse);
}
