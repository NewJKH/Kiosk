package org.example.pro.level1;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;
import org.example.core.domain.repository.MenuRepository;
import org.example.core.ui.CartUI;
import org.example.core.ui.CategoryUI;
import org.example.core.ui.MainMenuUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.CartService;
import org.example.pro.level1.service.MenuService;
import org.example.pro.level1.service.OrderService;

import java.util.List;

public class Kiosk {
    private final CartService cartService;
    private final MenuService menuService;
    private final OrderService orderService;

    private Category category;

    public Kiosk(CartRepository cartRepository, MenuRepository menuRepository) {
        this.cartService = new CartService(cartRepository);
        this.menuService = new MenuService(menuRepository);
        this.orderService = new OrderService(cartRepository,menuRepository);
        this.category = Category.NONE;
    }

    /**
     * 시작부분
     */
    public void start() {
        while (true) {
            boolean keepRunning = switch (category) {
                case NONE -> mainUI();
                case BURGERS, DRINKS, DESSERTS -> foodUI();
            };
            if (!keepRunning) break;
        }
    }
    /**
     *  카테고리 겸 메뉴 UI
     */
    private boolean mainUI() {
        CategoryUI categoryUI = new CategoryUI("MAIN MENU", List.of("Burgers", "Drinks", "Desserts"));
        categoryUI.view();

        switch (InputUtil.input(Integer.class)) {
            case 1 -> category = Category.BURGERS;
            case 2 -> category = Category.DRINKS;
            case 3 -> category = Category.DESSERTS;
            case 0 -> {
                return false;
            }
            default -> System.out.println("올바른 메뉴 번호를 입력해주세요.");
        }
        return true;
    }
    /**
     *  메뉴
     */
    private boolean foodUI() {
        List<MenuItem> items = menuService.getItemsByCategory(category);

        MainMenuUI menuUI = new MainMenuUI(category.name()+" MENU", items.stream()
                .map(MenuItem::toString)
                .toList());
        menuUI.view();

        int input = InputUtil.input(Integer.class);
        if (input == 0) {
            category = Category.NONE;
        } else if (input >= 1 && input <= items.size()) {
            select(items.get(input-1));
        } else {
            System.out.println(" 메뉴 번호가 유효하지 않습니다.");
        }

        return true;
    }

    private void select(MenuItem item) {
        String display = item.toString();
        CartUI cartUI = new CartUI(display);
        System.out.println(" 선택한 메뉴: "+display);
        cartUI.view();
        int input = InputUtil.input(Integer.class);
        if ( input == 1){
            cartService.addToCart(item);
            System.out.println(item.getName()+" 이 장바구니에 추가되었습니다.");
            category = Category.NONE;
        }
    }
}
