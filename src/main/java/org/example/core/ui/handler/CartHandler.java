package org.example.core.ui.handler;

import org.example.core.domain.model.MenuItem;
import org.example.core.ui.UIHandler;
import org.example.core.ui.ui.CartUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.CartService;

public class CartHandler extends UIHandler<Integer> {

    private final MenuItem menuItem;
    private final CartService cartService;
    private final Runnable cancel;

    public CartHandler(MenuItem menuItem, CartService cartService, Runnable cancel) {
        this.menuItem = menuItem;
        this.cartService = cartService;
        this.cancel = cancel;
    }

    @Override
    protected void showUI() {
        CartUI cartUI = new CartUI(menuItem.toString());
        cartUI.view();
    }

    @Override
    protected Integer getInput() {
        return InputUtil.input(Integer.class);
    }

    @Override
    protected void handleInput(Integer input) {
        if (input == 1) {
            cartService.addToCart(menuItem);
            System.out.println(menuItem.getName() + "이(가) 장바구니에 추가되었습니다.");
        } else if (input == 2) {
            if (cancel != null) {
                cancel.run();
            }
        } else {
            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }
    }
}