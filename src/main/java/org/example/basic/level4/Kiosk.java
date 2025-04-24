package org.example.basic.level4;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;
import org.example.core.ui.CategoryUI;
import org.example.core.ui.MainMenuUI;
import org.example.core.verification.InputUtil;

import java.util.List;

public class Kiosk {
    private final Menu menu;
    private Category category;

    public Kiosk(Menu menu) {
        this.menu = menu;
        this.category = Category.NONE;
    }

    /**
     * 시작부분
     */
    public void start() {
        while (true) {
            boolean keepRunning = switch (category) {
                case NONE -> mainUI();
                case BURGERS -> burgersUI();
                default -> {
                    System.out.println("아직 구현되지 않은 카테고리입니다.");
                    yield false;
                }
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
            case 2, 3 -> System.out.println("이건 구현내용에 없습니다.");
            case 0 -> {
                return false;
            }
            default -> System.out.println("올바른 메뉴 번호를 입력해주세요.");
        }
        return true;
    }
    /**
     *  버거 메뉴
     */
    private boolean burgersUI() {
        List<MenuItem> items = menu.menuItems();

        MainMenuUI burgerMenu = new MainMenuUI("BURGERS MENU", items.stream()
                .map(MenuItem::toString)
                .toList());
        burgerMenu.view();

        int input = InputUtil.input(Integer.class);

        if (input == 0) {
            category = Category.NONE;
        } else if (input >= 1 && input <= items.size()) {
            System.out.println(" 선택한 메뉴: "+items.get(input-1).toString());
        } else {
            System.out.println(" 메뉴 번호가 유효하지 않습니다.");
        }

        return true;
    }
}
