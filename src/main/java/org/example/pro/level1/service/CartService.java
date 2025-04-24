package org.example.pro.level1.service;

import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;

public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(MenuItem menuItem){
        cartRepository.addCart(menuItem);
    }

    public void initCart(){
        cartRepository.initCart();
    }
}
