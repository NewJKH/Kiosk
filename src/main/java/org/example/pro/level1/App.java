package org.example.pro.level1;

import org.example.core.domain.repository.CartRepository;
import org.example.core.domain.repository.MenuRepository;

public class App {
    public static void main(String[] args) {
        CartRepository cartRepository = new CartRepository();
        MenuRepository menuRepository = new MenuRepository();

        Kiosk kiosk = new Kiosk(cartRepository, menuRepository);
        kiosk.start();
    }
}
