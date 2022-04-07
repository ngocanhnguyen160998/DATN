package com.service;

import com.model.Category;
import com.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();

    Optional<Category> getById(Long id);

    Category updateById(Long id, Category category);

    void deleteById(Long id);

    Category insert(Category category);
}
