package com.fsse.ecommerce.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactionProduct")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tpid;

    @ManyToOne
    @JoinColumn(name = "tid", nullable = false)
    private TransactionEntity transaction;

    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    private ProductEntity product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    public Long getTpid() {
        return tpid;
    }

    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "TransactionProductEntity{" +
                "tpid=" + tpid +
                ", transaction=" + transaction +
                ", product=" + product +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
