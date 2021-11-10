package com.fsse.ecommerce.api;

import com.fsse.ecommerce.domain.CartItem;
import com.fsse.ecommerce.domain.User;
import com.fsse.ecommerce.domain.dto.response.ResultResponseDto;
import com.fsse.ecommerce.domain.dto.response.cart.CartItemResponseDto;
import com.fsse.ecommerce.service.CartService;
import com.fsse.ecommerce.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartApi {
    @Autowired
    private CartService cartService;

    @PutMapping("/add-item/{pid}/quantity/{quantity}")
    public ResultResponseDto addItemToCart(
            Principal principal,
            @PathVariable("pid") Long pid,
            @PathVariable("quantity") Integer quantity
    ) {
        User user = SecurityUtil.getUser(principal);
        CartItem cartItem = cartService.addProduct(user.getUid(), pid, quantity);
        if (cartItem != null) {
            return ResultResponseDto.success();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public List<CartItemResponseDto> getCart(Principal principal) {
        User user = SecurityUtil.getUser(principal);
        List<CartItem> cartItems = cartService.getCart(user.getUid());
        List<CartItemResponseDto> dtos = new ArrayList<>();
        for (CartItem item : cartItems) {
            dtos.add(new CartItemResponseDto(item));
        }
        return dtos;
    }

    @PatchMapping("/{pid}/quantity/{quantity}")
    public CartItemResponseDto updateItemQuantity(
            Principal principal,
            @PathVariable("pid") Long pid,
            @PathVariable("quantity") Integer quantity
    ) {
        User user = SecurityUtil.getUser(principal);
        CartItem item = cartService.updateItemQuantity(user.getUid(), pid, quantity);
        if (item != null) {
            return new CartItemResponseDto(item);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove-item/{pid}")
    public ResultResponseDto deleteItemFromCart(
            Principal principal,
            @PathVariable("pid") Long pid
    ) {
        User user = SecurityUtil.getUser(principal);
        CartItem item = cartService.removeItemFromCart(user.getUid(), pid);
        if (item != null) {
            return ResultResponseDto.success();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
