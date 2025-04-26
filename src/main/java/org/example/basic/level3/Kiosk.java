package org.example.basic.level3;

import org.example.core.domain.model.MenuItem;
import org.example.core.ui.ui.MainMenuUI;
import org.example.core.verification.InputUtil;

import java.util.List;

public class Kiosk {
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start(){
        MainMenuUI menu = new MainMenuUI(
                "SHAKESHACK MENU"
                ,menuItems.stream()
                .map(MenuItem::toString)
                .toList()
        );
        while (true){
            menu.view();
            int number = InputUtil.input(Integer.class);
            if ( number == 0) return;
        }
    }
}
