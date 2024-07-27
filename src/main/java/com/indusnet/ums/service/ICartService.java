//package com.indusnet.ums.service;
package com.indusnet.ums.service;

import com.indusnet.ums.model.CartItemModel;
import com.indusnet.ums.model.CartModel;

import java.util.Optional;

public interface ICartService {
    CartModel createCart(String userId);
    Optional<CartModel> getCartById(String cartId);
    CartModel addItemToCart(String cartId, CartItemModel cartItem);
    CartModel removeItemFromCart(String cartId, String productId);
    CartModel updateCartItemQuantity(String cartId, String productId, int quantity);
    double calculateCartTotal(String cartId);
}
