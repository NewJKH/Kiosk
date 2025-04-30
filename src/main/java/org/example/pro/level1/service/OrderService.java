package org.example.pro.level1.service;

import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;
import org.example.pro.level2.CustomerType;

import java.util.Map;

/**
 * OrderService 클래스는 주문과 관련된 로직을 담당합니다.
 * 총 금액 계산, 주문 완료 처리, 장바구니 초기화 기능을 제공합니다.
 */
public class OrderService {
    private final CartRepository cartRepository;

    /**
     * OrderService 객체를 생성합니다.
     *
     * @param cartRepository 장바구니 데이터를 관리하는 저장소
     */
    public OrderService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /**
     * 주문을 완료하고 장바구니를 초기화합니다.
     */
    public void purchase() {
        // 구매 로직......
        cartRepository.initCart();
    }

    /**
     * 고객 유형에 따라 할인된 총 금액을 계산합니다.
     *
     * @param target 고객 유형
     * @return 할인 적용 후의 총 금액
     */
    public double getTotalPrice(CustomerType target) {
        Map<MenuItem, Integer> cart = cartRepository.getCarts();

        double total = cart.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();

        double discount = total * target.getDiscount();

        return total - discount;
    }

    /**
     * 장바구니가 비어있는지 여부를 반환합니다.
     *
     * @return true: 장바구니 비어 있음, false: 아이템이 있음
     */
    public boolean isEmpty() {
        return cartRepository.isEmpty();
    }

    /**
     * 장바구니를 초기화합니다.
     */
    public void clear() {
        cartRepository.initCart();
    }
}