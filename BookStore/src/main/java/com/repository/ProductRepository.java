package com.repository;

import com.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByIdAsc();

    @Query(value = "SELECT p.* FROM PRODUCT p LEFT JOIN WAREHOUSE w ON p.id = w.product_id WHERE w.id IS NULL", nativeQuery = true)
    List<Product> getAllProductNotExistWarehouse();
}
