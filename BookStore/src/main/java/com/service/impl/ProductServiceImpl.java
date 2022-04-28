package com.service.impl;

import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final String UPLOAD = "/image/";

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product updateById(Long id, Product product) {
        Product tmp = productRepository.findById(id).get();
        if (tmp == null) {
            return null;
        }
        tmp.setName(product.getName());
        tmp.setImage(UPLOAD + product.getImage());
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
        product.setImage(UPLOAD + product.getImage());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProductNotExistWarehouse() {
        return productRepository.getAllProductNotExistWarehouse();
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public long countByNameLike(String name) {
        return productRepository.countByNameLike(name);
    }

    @Override
    public long countByCategoryId(String categoryId) {
        if ("".equals(categoryId)) {
            return productRepository.count();
        }
        return productRepository.countByCategoryId(categoryId);
    }

    @Override
    public List<Product> get8ProductHot() {
        return productRepository.find8ProductHot();
    }

    @Override
    public List<Product> get8ProductSale() {
        return productRepository.find8ProductSale();
    }

    @Override
    public List<Product> get8ProductNew() {
        return productRepository.find8ProductNew();
    }

    @Override
    public List<Product> get8ProductByCategory(String categoryId) {
        return productRepository.find8ProductByCategoryId(categoryId);
    }

    @Override
    public List<Product> get8ProductRandomByCategory(String categoryId, String productId) {
        return productRepository.find8ProductRandomByCategoryId(categoryId, productId);
    }
}
