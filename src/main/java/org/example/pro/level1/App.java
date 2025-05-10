package org.example.pro.level1;

import org.example.core.domain.repository.CartRepository;
import org.example.core.domain.repository.MenuRepository;
import org.example.pro.level1.service.CartService;
import org.example.pro.level1.service.MenuService;
import org.example.pro.level1.service.OrderService;

public class App {
    public static void main(String[] args) {

        CartRepository cartRepository = new CartRepository();
        MenuRepository menuRepository = new MenuRepository();

        CartService cartService = new CartService(cartRepository);
        MenuService menuService = new MenuService(menuRepository);
        OrderService orderService = new OrderService(cartRepository);


        Kiosk kiosk = new Kiosk(cartService,menuService,orderService);
        kiosk.start();
    }
}
