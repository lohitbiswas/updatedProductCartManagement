package com.indusnet.ums.controller;


import com.indusnet.ums.model.CartModel;
//import com.indusnet.ums.service.ICartService;
import com.indusnet.ums.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private ICartService cartService;

    // Create a new cart
    @PostMapping
    public ResponseEntity<CartModel> createCart(String userId) {
        CartModel cart = cartService.createCart(userId);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    // Get a cart by ID
    @GetMapping("/{cartId}")
    public ResponseEntity<CartModel> getCartById(@PathVariable String cartId) {
        Optional<CartModel> cartOptional = cartService.getCartById(cartId);
        return cartOptional.map(cart -> new ResponseEntity<>(cart, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a cart (e.g., add, remove, or update items)
    // For more granular control, consider separate endpoints for adding, removing, and updating items
    @PutMapping("/{cartId}")
    public ResponseEntity<CartModel> updateCart(String cartId, String productId, int quantity) {
        // Logic to update cart based on request body
        CartModel updatedCart = cartService.updateCartItemQuantity(cartId,productId,quantity);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    // Delete a cart
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId,String productId) {
        cartService.removeItemFromCart(cartId,productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

