package com.fsse.ecommerce.service;

import com.fsse.ecommerce.domain.CartItem;
import com.fsse.ecommerce.domain.entity.CartItemEntity;

import java.util.List;

public interface CartService {
    CartItem addProduct(long uid, long pid, int quantity);
    List<CartItem> getCart(long uid);
    List<CartItemEntity> getCartEntities(long uid);
    CartItem updateItemQuantity(long uid, long pid, int quantity);
    CartItem removeItemFromCart(long uid, long pid);
    void emptyCart(long uid);
}
