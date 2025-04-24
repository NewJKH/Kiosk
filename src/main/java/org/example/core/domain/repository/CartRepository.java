package org.example.core.domain.repository;

import org.example.core.domain.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private List<MenuItem> menuItems;

    public CartRepository() {
        this.menuItems = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.menuItems.isEmpty();
    }

    public void addCart(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }

    public void initCart(){
        this.menuItems = new ArrayList<>();
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}
