package org.example.core.ui.handler;

import org.example.core.domain.model.Category;
import org.example.core.ui.UIHandler;
import org.example.core.ui.ui.CategoryUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainMenuHandler extends UIHandler<Integer> {

    private final OrderService orderService;
    private final Consumer<Category> category;
    private final Runnable purchase;
    private final Runnable cancel;
    private final Runnable exit;

    public MainMenuHandler(OrderService orderService,
                           Consumer<Category> category,
                           Runnable purchase,
                           Runnable cancel,
                           Runnable exit) {
        this.orderService = orderService;
        this.category = category;
        this.purchase = purchase;
        this.cancel = cancel;
        this.exit = exit;
    }

    @Override
    protected void showUI() {
        List<String> menuOptions = new ArrayList<>(List.of("Burgers", "Drinks", "Desserts"));

        if (!orderService.isEmpty()) {
            menuOptions.add("Orders       | 장바구니를 확인 후 주문합니다.");
            menuOptions.add("Cancel       | 진행중인 주문을 취소합니다.");
        }

        CategoryUI categoryUI = new CategoryUI("MAIN MENU", menuOptions);
        categoryUI.view();
    }

    @Override
    protected Integer getInput() {
        return InputUtil.input(Integer.class);
    }

    @Override
    protected void handleInput(Integer input) {
        boolean hasOrder = !orderService.isEmpty();
        switch (input) {
            case 1 -> category.accept(Category.BURGERS);
            case 2 -> category.accept(Category.DRINKS);
            case 3 -> category.accept(Category.DESSERTS);
            case 4 -> {
                if (hasOrder) purchase.run();
                else invalidInput();
            }
            case 5 -> {
                if (hasOrder) cancel.run();
                else invalidInput();
            }
            case 0 -> exit.run();
            default -> invalidInput();
        }
    }

    private void invalidInput() {
        System.out.println("올바른 메뉴 번호를 입력해주세요.");
    }
}
