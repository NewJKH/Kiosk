package org.example.core.ui.handler;

import org.example.core.domain.model.MenuItem;
import org.example.core.ui.UIHandler;
import org.example.core.ui.ui.CartUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.CartService;

/**
 * CartHandler 클래스는 특정 메뉴 아이템을 장바구니에 추가할지 여부를 사용자에게 묻고,
 * 입력에 따라 장바구니에 추가하거나 취소하는 로직을 처리합니다.
 * {@link UIHandler}를 상속하여 템플릿 메서드 패턴을 따릅니다.
 */
public class CartHandler extends UIHandler<Integer> {

    private final MenuItem menuItem;
    private final CartService cartService;
    private final Runnable cancel;

    /**
     * CartHandler 객체를 생성합니다.
     *
     * @param menuItem     장바구니에 추가할 대상 메뉴 아이템
     * @param cartService  장바구니 서비스를 통해 실제 데이터 처리
     * @param cancel       사용자가 '취소'를 선택했을 때 실행할 동작 (콜백)
     */
    public CartHandler(MenuItem menuItem, CartService cartService, Runnable cancel) {
        this.menuItem = menuItem;
        this.cartService = cartService;
        this.cancel = cancel;
    }

    /**
     * 장바구니에 아이템을 추가할 것인지 선택하는 UI를 보여줍니다.
     */
    @Override
    protected void showUI() {
        CartUI cartUI = new CartUI(menuItem.toString());
        cartUI.view();
    }

    /**
     * 사용자로부터 입력(1: 담기, 2: 취소)을 받습니다.
     *
     * @return 입력된 정수 값
     */
    @Override
    protected Integer getInput() {
        return InputUtil.input(Integer.class);
    }

    /**
     * 사용자 입력에 따라 아이템을 장바구니에 추가하거나 취소 동작을 수행합니다.
     *
     * @param input 사용자 입력값 (1: 추가, 2: 취소)
     */
    @Override
    protected void handleInput(Integer input) {
        if (input == 1) {
            cartService.addToCart(menuItem);
            System.out.println(menuItem.getName() + "이(가) 장바구니에 추가되었습니다.");
        } else if (input == 2) {
            cancel.run();
        } else {
            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }
    }
}
