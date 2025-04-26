package org.example.core.ui.handler;

import org.example.core.ui.UIHandler;
import org.example.core.ui.ui.CustomerUI;
import org.example.core.verification.InputUtil;
import org.example.pro.level1.service.OrderService;
import org.example.pro.level2.CustomerType;

public class CustomerHandler extends UIHandler<Integer> {
    private final OrderService orderService;

    public CustomerHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    protected void showUI() {
        CustomerUI customerUI = new CustomerUI();
        customerUI.view();
    }

    @Override
    protected Integer getInput() {
        return InputUtil.input(Integer.class);
    }

    @Override
    protected void handleInput(Integer input) {
        CustomerType.findByIndex(input).ifPresentOrElse(target -> {
            double totalPrice = orderService.getTotalPrice(target);
            orderService.purchase();
            System.out.printf(
                    "주문이 완료되었습니다.\n선택한 대상: %s\n할인율: %.0f%%\n최종 결제 금액: ₩ %.0f\n",
                    target.getLabel(),
                    target.getDiscount() * 100,
                    totalPrice
            );
        }, () -> {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
        });
    }
}
