package com.fsse.ecommerce.repository;

import com.fsse.ecommerce.domain.entity.CartItemEntity;
import com.fsse.ecommerce.domain.entity.ProductEntity;
import com.fsse.ecommerce.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Long> {
    CartItemEntity findFirstByUserAndProduct(UserEntity user, ProductEntity product);
    List<CartItemEntity> findByUser_Uid(Long uid);
}
