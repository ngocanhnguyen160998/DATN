package com.service;

import com.dto.ProductDTO;
import com.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getById(Long id);

    Product updateById(Long id, Product product);

    void deleteById(Long id);

    Product insert(Product product);
}
