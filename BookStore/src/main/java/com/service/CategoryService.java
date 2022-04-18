package com.service;

import com.model.Category;
import com.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();

    List<Category> getAll(Pageable pageable);

    Optional<Category> getById(Long id);

    Category updateById(Long id, Category category);

    void deleteById(Long id);

    Category insert(Category category);

    long count();

    long countByNameLike(String name);
}
