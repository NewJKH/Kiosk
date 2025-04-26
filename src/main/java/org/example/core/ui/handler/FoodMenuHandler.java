package org.example.core.ui.handler;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;
import org.example.core.ui.UIHandler;
import org.example.core.ui.ui.MainMenuUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.MenuService;

import java.util.List;
import java.util.function.Consumer;

public class FoodMenuHandler extends UIHandler<Integer> {

    private final Category category;
    private final MenuService menuService;
    private final Consumer<MenuItem> selectItem;
    private final Runnable onExit;

    public FoodMenuHandler(Category category,
                           MenuService menuService,
                           Consumer<MenuItem> selectItem,
                           Runnable onExit) {
        this.category = category;
        this.menuService = menuService;
        this.selectItem = selectItem;
        this.onExit = onExit;
    }

    private List<MenuItem> items;

    @Override
    protected void showUI() {
        items = menuService.getItemsByCategory(category);

        MainMenuUI menuUI = new MainMenuUI(
                category.name() + " MENU",
                items.stream()
                        .map(MenuItem::toString)
                        .toList()
        );
        menuUI.view();
    }

    @Override
    protected Integer getInput() {
        return InputUtil.input(Integer.class);
    }

    @Override
    protected void handleInput(Integer input) {
        if (input == 0) {
            onExit.run();
        } else if (input >= 1 && input <= items.size()) {
            selectItem.accept(items.get(input - 1));
        } else {
            System.out.println(" 메뉴 번호가 유효하지 않습니다.");
        }
    }
}
