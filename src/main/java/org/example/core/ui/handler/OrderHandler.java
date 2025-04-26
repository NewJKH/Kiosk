package org.example.core.ui.handler;

import org.example.core.domain.model.MenuItem;
import org.example.core.ui.UIHandler;
import org.example.core.ui.ui.OrderUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.CartService;
import org.example.pro.level1.service.OrderService;
import org.example.pro.level2.CustomerType;

import java.util.Map;

public class OrderHandler extends UIHandler<Integer> {
    private final CartService cartService;
    private final OrderService orderService;
    private final Runnable selectCustomer;
    private final Runnable cancel;

    public OrderHandler(CartService cartService,
            OrderService orderService,
            Runnable selectCustomer,
            Runnable cancel) {
        this.cartService = cartService;
        this.orderService = orderService;
        this.selectCustomer = selectCustomer;
        this.cancel = cancel;
    }

    @Override
    protected void showUI() {
        Map<MenuItem, Integer> cart = cartService.getCartItems();
        double total = orderService.getTotalPrice(CustomerType.GENERAL);

        OrderUI orderUI = new OrderUI(cart, total);
        orderUI.view();
    }

    @Override
    protected Integer getInput() {
        return InputUtil.input(Integer.class);
    }

    @Override
    protected void handleInput(Integer input) {
        if (input == 1) {
            selectCustomer.run();
        }else if ( input == 2){
            cancel.run();
        }
    }
}
