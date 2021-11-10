package com.fsse.ecommerce.service.impl;

import com.fsse.ecommerce.domain.Transaction;
import com.fsse.ecommerce.domain.entity.CartItemEntity;
import com.fsse.ecommerce.domain.entity.TransactionEntity;
import com.fsse.ecommerce.domain.entity.TransactionProductEntity;
import com.fsse.ecommerce.domain.entity.UserEntity;
import com.fsse.ecommerce.domain.enumeration.TransactionStatus;
import com.fsse.ecommerce.repository.TransactionProductRepository;
import com.fsse.ecommerce.repository.TransactionRepository;
import com.fsse.ecommerce.service.CartService;
import com.fsse.ecommerce.service.TransactionService;
import com.fsse.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private CartService cartService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionProductRepository transactionProductRepository;

    @Override
    public Transaction prepareTransaction(long uid) {
        List<CartItemEntity> cartItems = cartService.getCartEntities(uid);
        if (cartItems.size() <= 0) {
            return null;
        }
        UserEntity userEntity = cartItems.get(0).getUser();

        BigDecimal total = BigDecimal.ZERO;
        List<TransactionProductEntity> transactionProductEntities = new ArrayList<>();
        for (CartItemEntity item : cartItems) {
            BigDecimal subtotal = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(subtotal);

            TransactionProductEntity entity = new TransactionProductEntity();
            entity.setProduct(item.getProduct());
            entity.setQuantity(item.getQuantity());
            entity.setSubtotal(subtotal);
            transactionProductEntities.add(entity);
        }

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setDateTime(LocalDateTime.now());
        transactionEntity.setBuyer(userEntity);
        transactionEntity.setStatus(TransactionStatus.PREPARE);
        transactionEntity.setTotal(total);

        transactionEntity = transactionRepository.save(transactionEntity);

        for (int i=0; i<transactionProductEntities.size(); i++) {
            TransactionProductEntity item = transactionProductEntities.get(i);
            item.setTransaction(transactionEntity);
            transactionProductEntities.set(i, transactionProductRepository.save(item));
        }

        return new Transaction(transactionEntity, transactionProductEntities);
    }

    @Override
    public Transaction getTransactionByTid(long uid, long tid) {
        Optional<TransactionEntity> transactionEntityOpt = transactionRepository.findById(tid);

        if (transactionEntityOpt.isPresent() && transactionEntityOpt.get().getBuyer().getUid().equals(uid)) {
            TransactionEntity transactionEntity = transactionEntityOpt.get();
            List<TransactionProductEntity> transactionProductEntities = transactionProductRepository.findByTransaction(transactionEntity);
            return new Transaction(transactionEntity, transactionProductEntities);
        } else {
            return null;
        }
    }

    @Override
    public Transaction completeTransaction(long uid, long tid) {
        Optional<TransactionEntity> transactionEntityOpt = transactionRepository.findById(tid);

        if (transactionEntityOpt.isPresent() && transactionEntityOpt.get().getBuyer().getUid().equals(uid)) {
            TransactionEntity transactionEntity = transactionEntityOpt.get();

            transactionEntity.setStatus(TransactionStatus.SUCCESS);
            transactionEntity = transactionRepository.save(transactionEntity);

            cartService.emptyCart(uid);

            List<TransactionProductEntity> transactionProductEntities = transactionProductRepository.findByTransaction(transactionEntity);
            return new Transaction(transactionEntity, transactionProductEntities);
        } else {
            return null;
        }
    }
}
