package com.fsse.ecommerce.domain.dto.response.cart;

import com.fsse.ecommerce.domain.CartItem;

import java.math.BigDecimal;

public class CartItemResponseDto {
    private Long pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer cartQuantity;
    private Integer stock;

    public CartItemResponseDto(CartItem item) {
        this.pid = item.getProduct().getPid();
        this.name = item.getProduct().getName();
        this.imageUrl = item.getProduct().getImageUrl();
        this.price = item.getProduct().getPrice();
        this.cartQuantity = item.getQuantity();
        this.stock = item.getProduct().getStock();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "CartItemResponseDto{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", cartQuantity=" + cartQuantity +
                ", stock=" + stock +
                '}';
    }
}
