package org.example.pro.level1.service;

import org.example.core.domain.model.MenuItem;
import org.example.core.domain.repository.CartRepository;

import java.util.Map;


/**
 * CartService 클래스는 장바구니에 메뉴 아이템을 추가하고,
 * 현재 장바구니 상태를 조회하는 역할을 합니다.
 */
public class CartService {
    private final CartRepository cartRepository;

    /**
     * CartService 객체를 생성합니다.
     *
     * @param cartRepository 장바구니 데이터를 처리하는 저장소
     */
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /**
     * 지정된 메뉴 아이템을 장바구니에 추가합니다.
     *
     * @param menuItem 장바구니에 추가할 메뉴 아이템
     */
    public void addToCart(MenuItem menuItem) {
        cartRepository.addCart(menuItem);
    }

    /**
     * 현재 장바구니에 담긴 모든 항목과 수량을 반환합니다.
     *
     * @return 장바구니의 메뉴 항목과 각 수량이 담긴 Map
     */
    public Map<MenuItem, Integer> getCartItems() {
        return cartRepository.getCarts();
    }
}
