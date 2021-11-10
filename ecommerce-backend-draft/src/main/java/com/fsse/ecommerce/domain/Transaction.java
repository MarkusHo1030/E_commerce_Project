package com.fsse.ecommerce.domain;

import com.fsse.ecommerce.domain.entity.TransactionEntity;
import com.fsse.ecommerce.domain.entity.TransactionProductEntity;
import com.fsse.ecommerce.domain.enumeration.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Long tid;
    private User buyer;
    private LocalDateTime dateTime;
    private TransactionStatus transactionStatus;
    private BigDecimal total;
    private List<TransactionProduct> transactionProducts;

    public Transaction(TransactionEntity entity, List<TransactionProductEntity> transactionProductEntities) {
        this.tid = entity.getTid();
        this.buyer = new User(entity.getBuyer());
        this.dateTime = entity.getDateTime();
        this.transactionStatus = entity.getStatus();
        this.total = entity.getTotal();
        this.transactionProducts = new ArrayList<>();
        for (TransactionProductEntity tp : transactionProductEntities) {
            this.transactionProducts.add(new TransactionProduct(tp));
        }
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(List<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", buyer=" + buyer +
                ", dateTime=" + dateTime +
                ", transactionStatus=" + transactionStatus +
                ", total=" + total +
                ", transactionProducts=" + transactionProducts +
                '}';
    }
}
