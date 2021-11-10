package com.fsse.ecommerce.service;

import com.fsse.ecommerce.domain.Product;
import com.fsse.ecommerce.domain.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductByPid(Long pid);
    ProductEntity getProductEntityByPid(Long pid);
}
