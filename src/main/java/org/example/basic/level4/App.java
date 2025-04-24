package org.example.basic.level4;

import org.example.core.domain.model.MenuItem;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu(List.of(
                new MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9),
                new MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9),
                new MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9),
                new MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4))
        );

        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}
