package com.fsse.ecommerce.service.impl;

import com.fsse.ecommerce.domain.Product;
import com.fsse.ecommerce.domain.entity.ProductEntity;
import com.fsse.ecommerce.repository.ProductRepository;
import com.fsse.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        Iterable<ProductEntity> entities = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductEntity entity : entities) {
            products.add(new Product(entity));
        }

        return products;
    }

    @Override
    public Product getProductByPid(Long pid) {
        Optional<ProductEntity> entityOpt = productRepository.findById(pid);
        if (entityOpt.isPresent()) {
            return new Product(entityOpt.get());
        }
        return null;
    }

    @Override
    public ProductEntity getProductEntityByPid(Long pid) {
        Optional<ProductEntity> entityOpt = productRepository.findById(pid);
        if (entityOpt.isPresent()) {
            return entityOpt.get();
        }
        return null;
    }
}
