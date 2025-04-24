package org.example.core.domain.repository;

import org.example.core.domain.model.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class CartRepository {
    // String - 상품의 이름, Integer 갯수
    private final Map<MenuItem, Integer> carts;

    public CartRepository() {
        carts = new HashMap<>();
    }
    public void addCart(MenuItem menuItem){
        int quantity = carts.getOrDefault(menuItem, 0);
        carts.put(menuItem, quantity + 1);
    }

    public void initCart(){
        carts.clear();
    }

    public boolean isEmpty(){
        return carts.isEmpty();
    }

    public Map<MenuItem, Integer> getCarts() {
        return carts;
    }
}
