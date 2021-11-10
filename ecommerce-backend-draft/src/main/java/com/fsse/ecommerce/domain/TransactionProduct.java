package com.fsse.ecommerce.domain;

import com.fsse.ecommerce.domain.entity.TransactionProductEntity;

import java.math.BigDecimal;

public class TransactionProduct {
    private Long tpid;
    private Product product;
    private Integer quantity;
    private BigDecimal subtotal;

    public TransactionProduct(TransactionProductEntity entity) {
        this.tpid = entity.getTpid();
        this.product = new Product(entity.getProduct());
        this.quantity = entity.getQuantity();
        this.subtotal = entity.getSubtotal();
    }

    public Long getTpid() {
        return tpid;
    }

    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
        return "TransactionProduct{" +
                "tpid=" + tpid +
                ", product=" + product +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
