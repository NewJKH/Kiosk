package org.example.basic.level4;

import org.example.core.domain.model.MenuItem;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
