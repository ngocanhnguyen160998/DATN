package com.repository;

import com.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(value = "SELECT COUNT(w.id) FROM PRODUCT p, WAREHOUSE w WHERE p.id = w.product_id AND p.name LIKE %:name%", nativeQuery = true)
    Long countByNameLike(@Param("name") String name);
}
