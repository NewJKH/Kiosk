package org.example.pro.level1;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;
import org.example.core.domain.repository.MenuRepository;
import org.example.core.ui.handler.*;
import org.example.pro.level1.service.CartService;
import org.example.pro.level1.service.MenuService;
import org.example.pro.level1.service.OrderService;

public class Kiosk {
    private final CartService cartService;
    private final MenuService menuService;
    private final OrderService orderService;

    private Category category;

    public Kiosk(CartRepository cartRepository, MenuRepository menuRepository) {
        this.cartService = new CartService(cartRepository);
        this.menuService = new MenuService(menuRepository);
        this.orderService = new OrderService(cartRepository);

        this.category = Category.NONE;
    }

    public void start() {
        while (true) {
            boolean keepRunning = switch (category) {
                case NONE -> mainUI();
                case BURGERS, DRINKS, DESSERTS -> foodUI();
            };
            if (!keepRunning) break;
        }
    }


    private boolean mainUI() {
        MainMenuHandler handler = new MainMenuHandler(orderService,
                selectedCategory -> category = selectedCategory,
                this::orderUI,
                orderService::clear,
                () -> category = Category.NONE
        );
        handler.process();
        return handler.isDone();
    }

    private boolean foodUI() {
        new FoodMenuHandler(category, menuService,
                this::cartUI,
                () -> category = Category.NONE
        ).process();
        return true;
    }

    private void cartUI(MenuItem item) {
        new CartHandler(item, cartService,
                () -> {
                    System.out.println("취소되었습니다.");
                    category = Category.NONE;
                }
        ).process();
    }

    private void orderUI() {
        new OrderHandler(cartService,orderService,
                this::selectCustomer,
                ()-> {
                    System.out.println("주문이 취소되었습니다.");
                    category = Category.NONE;
                }
        ).process();
    }


    private void selectCustomer() {
        new CustomerHandler(
                orderService
        ).process();
    }

}
