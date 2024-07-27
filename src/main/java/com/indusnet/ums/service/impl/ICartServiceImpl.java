package com.indusnet.ums.service.impl;

import com.indusnet.ums.exception.CartNotFoundException;
import com.indusnet.ums.model.CartItemModel;
import com.indusnet.ums.model.CartModel;
import com.indusnet.ums.repository.ICartRepository;
import com.indusnet.ums.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ICartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;
    @Override
    public CartModel createCart(String userId) {
        CartModel cart = new CartModel();
        return cartRepository.save(cart);
    }

    @Override
    public Optional<CartModel> getCartById(String cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public CartModel addItemToCart(String cartId, CartItemModel cartItem) {
        Optional<CartModel> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            CartModel cart = cartOptional.get();
            // Assuming you have a ProductService to fetch product
            // CartItem cartItem = new CartItem(product, quantity);
            // cart.getItems().add(cartItem);
            return cartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart not found");
        }
    }

    @Override
    public CartModel removeItemFromCart(String cartId, String productId) {
        Optional<CartModel> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            CartModel cart = cartOptional.get();
            cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
            return cartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart not found");
        }
    }

    @Override
    public CartModel updateCartItemQuantity(String cartId, String productId, int quantity) {
        Optional<CartModel> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            CartModel cart = cartOptional.get();
            cart.getItems().stream()
                    .filter(item -> item.getProduct().getId().equals(productId))
                    .findFirst()
                    .ifPresent(item -> item.setQuantity(quantity));
            return cartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart not found");
        }
    }

    @Override
    public double calculateCartTotal(String cartId) {
        Optional<CartModel> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            CartModel cart = cartOptional.get();

            return cart.getItems().stream()
                    .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                    .sum();
        } else {
            throw new CartNotFoundException("Cart not found");
        }
    }
}
