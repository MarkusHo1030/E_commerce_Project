package com.fsse.ecommerce.repository;

import com.fsse.ecommerce.domain.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
}
