package com.fsse.ecommerce.domain.dto.response.transaction;

import com.fsse.ecommerce.domain.TransactionProduct;
import com.fsse.ecommerce.domain.dto.response.product.ProductDetailResponseDto;

import java.math.BigDecimal;

public class TransactionItemResponseDto {
    private Long tpid;
    private Integer quantity;
    private ProductDetailResponseDto product;
    private BigDecimal subtotal;

    public TransactionItemResponseDto(TransactionProduct tp) {
        this.tpid = tp.getTpid();
        this.quantity = tp.getQuantity();
        this.product = new ProductDetailResponseDto(tp.getProduct());
        this.subtotal = tp.getSubtotal();
    }

    public Long getTpid() {
        return tpid;
    }

    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDetailResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductDetailResponseDto product) {
        this.product = product;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "TransactionItemResponseDto{" +
                "tpid=" + tpid +
                ", quantity=" + quantity +
                ", product=" + product +
                ", subtotal=" + subtotal +
                '}';
    }
}
