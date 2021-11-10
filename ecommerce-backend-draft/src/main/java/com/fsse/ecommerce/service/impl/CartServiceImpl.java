package com.fsse.ecommerce.service.impl;

import com.fsse.ecommerce.domain.CartItem;
import com.fsse.ecommerce.domain.entity.CartItemEntity;
import com.fsse.ecommerce.domain.entity.ProductEntity;
import com.fsse.ecommerce.domain.entity.UserEntity;
import com.fsse.ecommerce.repository.CartItemRepository;
import com.fsse.ecommerce.service.CartService;
import com.fsse.ecommerce.service.ProductService;
import com.fsse.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Override
    public CartItem addProduct(long uid, long pid, int quantity) {
        UserEntity userEntity = userService.getUserEntityByUid(uid);
        if (userEntity == null) {
            return null;
        }

        ProductEntity productEntity = productService.getProductEntityByPid(pid);
        if (productEntity == null || productEntity.getStock() <= 0) {
            return null;
        }

        if (quantity <= 0) {
            return null;
        }

        CartItemEntity entity = cartItemRepository.findFirstByUserAndProduct(userEntity, productEntity);
        if (entity == null) {
            if (quantity > productEntity.getStock()) {
                return null;
            }
            entity = new CartItemEntity();
            entity.setProduct(productEntity);
            entity.setUser(userEntity);
            entity.setQuantity(quantity);
        } else {
            if (entity.getQuantity() + quantity > productEntity.getStock()) {
                return null;
            }
            entity.setQuantity(entity.getQuantity() + quantity);
        }
        entity = cartItemRepository.save(entity);

        return new CartItem(entity);
    }
    @Override
    public List<CartItem> getCart(long uid) {
        List<CartItemEntity> entities = cartItemRepository.findByUser_Uid(uid);
        List<CartItem> doList = new ArrayList<>();
        for (CartItemEntity entity : entities) {
            doList.add(new CartItem(entity));
        }
        return doList;
    }

    @Override
    public List<CartItemEntity> getCartEntities(long uid) {
        return cartItemRepository.findByUser_Uid(uid);
    }

    @Override
    public CartItem updateItemQuantity(long uid, long pid, int quantity) {
        UserEntity userEntity = userService.getUserEntityByUid(uid);
        if (userEntity == null) {
            return null;
        }

        ProductEntity productEntity = productService.getProductEntityByPid(pid);
        if (productEntity == null || productEntity.getStock() <= 0) {
            return null;
        }

        if (quantity <= 0 || quantity > productEntity.getStock()) {
            return null;
        }

        CartItemEntity cartItemEntity = cartItemRepository.findFirstByUserAndProduct(userEntity, productEntity);
        if (cartItemEntity == null) {
            return null;
        }

        cartItemEntity.setQuantity(quantity);
        cartItemEntity = cartItemRepository.save(cartItemEntity);

        return new CartItem(cartItemEntity);
    }

    @Override
    public CartItem removeItemFromCart(long uid, long pid) {
        UserEntity userEntity = userService.getUserEntityByUid(uid);
        if (userEntity == null) {
            return null;
        }

        ProductEntity productEntity = productService.getProductEntityByPid(pid);
        if (productEntity == null || productEntity.getStock() <= 0) {
            return null;
        }

        CartItemEntity cartItemEntity = cartItemRepository.findFirstByUserAndProduct(userEntity, productEntity);
        if (cartItemEntity == null) {
            return null;
        }

        CartItem removedItem = new CartItem(cartItemEntity);
        cartItemRepository.delete(cartItemEntity);

        return removedItem;
    }

    @Override
    public void emptyCart(long uid) {
        List<CartItemEntity> cartItems = cartItemRepository.findByUser_Uid(uid);
        cartItemRepository.deleteAll(cartItems);
    }
}
