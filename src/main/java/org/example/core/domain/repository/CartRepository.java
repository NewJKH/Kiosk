package org.example.core.domain.repository;

import org.example.core.domain.model.MenuItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartRepository {
    // String - 상품의 이름, Integer 갯수
    private final Map<String, Integer> carts;

    public CartRepository() {
        carts = new HashMap<>();
    }
    public void addCart(MenuItem menuItem){
        int quantity = carts.getOrDefault(menuItem.getName(), 0);
        carts.put(menuItem.getName(), quantity + 1);
    }

    public void initCart(){
        carts.clear();
    }

    public boolean isEmpty(){
        return carts.isEmpty();
    }

    public int getEaByName(String name){
        return carts.getOrDefault(name,0);
    }

    public Set<String> getItemsName(){
        return carts.keySet();
    }

    public Map<String, Integer> getCarts() {
        return carts;
    }
}
