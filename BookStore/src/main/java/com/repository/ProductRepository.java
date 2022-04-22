package com.repository;

import com.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByIdAsc();

    @Query(value = "SELECT p.* FROM PRODUCT p LEFT JOIN WAREHOUSE w ON p.id = w.product_id WHERE w.id IS NULL", nativeQuery = true)
    List<Product> getAllProductNotExistWarehouse();

    @Query(value = "SELECT COUNT(p.id) FROM PRODUCT p WHERE name LIKE %:name%", nativeQuery = true)
    Long countByNameLike(@Param("name") String name);

    @Query(value = "SELECT COUNT(*) FROM PRODUCT p WHERE category_id = :categoryId", nativeQuery = true)
    Long countByCategoryId(@Param("categoryId") String categoryId);

    @Query(value = "SELECT * FROM product ORDER BY id DESC LIMIT 8", nativeQuery = true)
    List<Product> find8ProductNew();

    @Query(value = "SELECT p.* FROM product p, warehouse w WHERE p.id = w.product_id ORDER BY amount ASC LIMIT 8", nativeQuery = true)
    List<Product> find8ProductHot();

    @Query(value = "SELECT * FROM product WHERE sale_price > 0 AND sale_price < price ORDER BY id DESC LIMIT 8", nativeQuery = true)
    List<Product> find8ProductSale();

    @Query(value = "SELECT * FROM product WHERE category_id = :categoryId  ORDER BY id DESC LIMIT 8", nativeQuery = true)
    List<Product> find8ProductByCategoryId(@Param("categoryId") String categoryId);
}
