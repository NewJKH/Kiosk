package org.example.pro.level1;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;
import org.example.core.ui.handler.*;
import org.example.pro.level1.service.CartService;
import org.example.pro.level1.service.MenuService;
import org.example.pro.level1.service.OrderService;
/**
 * Kiosk 클래스는 키오스크 콘솔 애플리케이션의 메인 컨트롤러입니다.
 * 메뉴 탐색, 장바구니 처리, 주문 흐름을 제어하며 상태에 따라 화면 전환을 관리합니다.
 */
public class Kiosk {
    private final CartService cartService;
    private final MenuService menuService;
    private final OrderService orderService;

    private Category category;

    /**
     * Kiosk 객체를 생성합니다.
     * 내부적으로 CartService, MenuService, OrderService를 초기화합니다.
     *
     * @param cartService 장바구니 비즈니스 로직 처리
     * @param menuService 메뉴 비즈니스 로직 처리
     * @param orderService 주문관련 비즈니스 로직 처리
     */
    public Kiosk(CartService cartService, MenuService menuService, OrderService orderService) {
        this.cartService = cartService;
        this.menuService = menuService;
        this.orderService = orderService;
        this.category = Category.NONE;
    }
//    public Kiosk(CartRepository cartRepository, MenuRepository menuRepository) {
//        this.cartService = new CartService(cartRepository); <- 불필요한 객체생성 문제
//        this.menuService = new MenuService(menuRepository); <- 불필요한 객체생성 문제
//        this.orderService = new OrderService(cartRepository); <- 불필요한 객체생성 문제
//        this.category = Category.NONE;
//    }


    /**
     * 키오스크 프로그램을 실행합니다.
     * category 상태에 따라 메인 메뉴 또는 음식 메뉴 UI를 보여주고,
     * 사용자가 종료를 선택할 때까지 루프를 유지합니다.
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
     * 메인 메뉴 UI를 보여주고 입력을 처리합니다.
     * 카테고리 선택, 주문 진행, 초기화 등이 가능합니다.
     *
     * @return 사용자가 종료를 선택하면 false, 계속 진행하면 true
     */
    private boolean mainUI() {
        MainMenuHandler handler = new MainMenuHandler(
                orderService,
                selectedCategory -> category = selectedCategory,
                this::orderUI,
                orderService::clear,
                () -> category = Category.NONE
        );
        handler.process();
        return handler.isDone();
    }

    /**
     * 선택된 카테고리(BURGERS, DRINKS, DESSERTS)에 따라
     * 해당 음식 리스트를 보여주는 UI를 처리합니다.
     *
     * @return 항상 true 반환 (루프 계속 진행)
     */
    private boolean foodUI() {
        new FoodMenuHandler(
                category,
                menuService,
                this::cartUI,
                () -> category = Category.NONE
        ).process();
        return true;
    }

    /**
     * 특정 메뉴 아이템을 장바구니에 추가할 수 있는 UI를 처리합니다.
     *
     * @param item 장바구니에 추가할 메뉴 아이템
     */
    private void cartUI(MenuItem item) {
        new CartHandler(
                item,
                cartService,
                () -> {
                    System.out.println("취소되었습니다.");
                    category = Category.NONE;
                }
        ).process();
    }

    /**
     * 장바구니의 주문을 확인하고 결제를 진행하는 UI를 처리합니다.
     * 고객 정보 입력 또는 주문 취소 흐름으로 전환됩니다.
     */
    private void orderUI() {
        new OrderHandler(
                cartService,
                orderService,
                this::customerUI,
                () -> {
                    System.out.println("주문이 취소되었습니다.");
                    category = Category.NONE;
                }
        ).process();
    }

    /**
     * 고객 정보를 입력받는 UI를 처리합니다.
     * 주문이 최종적으로 완료됩니다.
     */
    private void customerUI() {
        new CustomerHandler(orderService).process();
    }
}