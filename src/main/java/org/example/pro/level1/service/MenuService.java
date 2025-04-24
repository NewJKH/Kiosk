package org.example.pro.level1.service;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public List<MenuItem> getItemsByCategory(Category category){
        return menuRepository.getMenuItemsByCategory(category);
    }
}
