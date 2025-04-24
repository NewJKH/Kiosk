package org.example.core.ui;

import java.util.ArrayList;
import java.util.List;

public class CartUI extends ConsoleUI{
    /*
    "SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
    위 메뉴를 장바구니에 추가하시겠습니까?
    1. 확인        2. 취소

     */
    private final String menuItem;

    public CartUI(String menuItem) {
        this.menuItem = menuItem;
    }


    @Override
    protected List<String> getFormattedLines() {
        List<String> lines = new ArrayList<>();
        lines.add(menuItem);
        lines.add("위 메뉴를 장바구니에 추가하시겠습니까?");
        lines.add("1. 확인        2. 취소");
        return lines;
    }

    public void view() {
        render();
    }
}
