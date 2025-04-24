package org.example.basic.level2;

import org.example.core.domain.model.MenuItem;
import org.example.core.ui.MainMenuUI;
import org.example.core.verification.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        menuItems.add(new MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        menuItems.add(new MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));
        menuItems.add(new MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4));

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
