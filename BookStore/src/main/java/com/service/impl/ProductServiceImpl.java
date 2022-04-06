package com.service.impl;

import com.model.Product;
import com.repository.DataAccess;
import com.repository.ProductRepository;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DataAccess dataAccess;

    @Override
    public List<Product> getAll() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateById(Long id, Product product) {
        Product tmp = productRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setName(product.getName());
        tmp.setImage(product.getImage());
        tmp.setInfo(product.getInfo());
        tmp.setDescriptions(product.getDescriptions());
        tmp.setPrice(product.getPrice());
        tmp.setSalePrice(product.getSalePrice());
        tmp.setCategoryId(product.getCategoryId());
        tmp.setAuthor(product.getAuthor());

        return productRepository.save(tmp);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }
}
