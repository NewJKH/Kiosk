package org.example.pro.level1.service;

import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;

import java.util.Map;

public class OrderService {
    private final CartRepository cartRepository;

    public OrderService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void purchase(){
        // 구매 로직......
        cartRepository.initCart();
    }

    public double getTotalPrice() {
        Map<MenuItem, Integer> cart = cartRepository.getCarts();
        return cart.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }

    public boolean isEmpty() {
        return cartRepository.isEmpty();
    }

    public void clear() {
        cartRepository.initCart();
    }
}
