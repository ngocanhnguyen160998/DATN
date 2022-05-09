package com.service;

import com.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getById(Long id);

    Optional<Product> getByName(String name);

    Product updateById(Long id, Product product);

    void deleteById(Long id);

    Product insert(Product product);

    List<Product> getAllProductNotExistWarehouse();

    long count();

    long countByNameLike(String name);

    long countByCategoryId(String categoryId);

    List<Product> get8ProductHot();

    List<Product> get8ProductSale();

    List<Product> get8ProductNew();

    List<Product> get8ProductByCategory(String categoryId);

    List<Product> get8ProductRandomByCategory(String categoryId, String productId);

    long countByProductHot();

    long countByProductSale();
}
