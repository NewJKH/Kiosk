package org.example.basic.level1;

import org.example.core.ui.MainMenuUI;
import org.example.core.verification.InputUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
        MainMenuUI menu = new MainMenuUI();
        List<String> arr = List.of(
                "[ SHAKESHACK MENU ]",
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거",
                "0. 종료      | 종료");

        while (true){
            menu.render(arr);
            int number = InputUtil.input(Integer.class);
            if ( number == 0) return;
        }
    }
}
