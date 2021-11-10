package com.fsse.ecommerce.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "cartItem")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_item_id", nullable = false, updatable = false, unique = true)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private UserEntity user;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemEntity{" +
                "cartItemId=" + cartItemId +
                ", product=" + product +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
