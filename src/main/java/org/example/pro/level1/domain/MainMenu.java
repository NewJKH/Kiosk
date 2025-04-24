package org.example.pro.level1.domain;

import org.example.core.domain.repository.MenuRepository;

public class MainMenu {
    private final MenuRepository menuRepository;

    public MainMenu() {
        menuRepository = new MenuRepository();
    }

}
