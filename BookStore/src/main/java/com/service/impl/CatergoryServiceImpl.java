package com.service.impl;

import com.model.Category;
import com.repository.CategoryRepository;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatergoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateById(Long id, Category category) {
        Category tmp = categoryRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setName(category.getName());
        return categoryRepository.save(tmp);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }
}
