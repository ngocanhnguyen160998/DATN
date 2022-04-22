package com.service;

import com.dto.WarehouseDTO;
import com.model.Warehouse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    List<Warehouse> getAll(Pageable pageable);

    Optional<Warehouse> getById(Long id);

    Warehouse updateById(Long id, WarehouseDTO warehouseDTO);

    Warehouse inputWarehouseById(Long id, WarehouseDTO warehouseDTO);

    void deleteById(Long id);

    Warehouse insert(Warehouse warehouse);

    long count();

    long countByLikeNameProduct(String name);
}
