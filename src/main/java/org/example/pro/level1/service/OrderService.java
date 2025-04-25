package org.example.pro.level1.service;

import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;
import org.example.pro.level2.CustomerType;

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

    public double getTotalPrice(CustomerType target) {
        Map<MenuItem, Integer> cart = cartRepository.getCarts();

        double total = cart.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();

        double discount = total * target.getDiscount();

        return total - discount;
    }


    public boolean isEmpty() {
        return cartRepository.isEmpty();
    }

    public void clear() {
        cartRepository.initCart();
    }
}
