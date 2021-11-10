package com.fsse.ecommerce.repository;

import com.fsse.ecommerce.domain.entity.TransactionEntity;
import com.fsse.ecommerce.domain.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity, Long> {
    List<TransactionProductEntity> findByTransaction(TransactionEntity transactionEntity);
}
