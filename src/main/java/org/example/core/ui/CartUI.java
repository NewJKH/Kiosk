package org.example.core.ui;

import java.util.ArrayList;
import java.util.List;

public class CartUI extends ConsoleUI{
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

    @Override
    public void view() {
        render();
    }
}
