package com.fsse.ecommerce.domain;

import com.fsse.ecommerce.domain.entity.CartItemEntity;

public class CartItem {
    private Long cartItemId;
    private User user;
    private Product product;
    private Integer quantity;

    public CartItem(CartItemEntity entity) {
        this.cartItemId = entity.getCartItemId();
        this.user = new User(entity.getUser());
        this.product = new Product(entity.getProduct());
        this.quantity = entity.getQuantity();
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
