package com.fsse.ecommerce.repository;

import com.fsse.ecommerce.domain.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
