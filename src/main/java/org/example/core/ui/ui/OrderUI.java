package org.example.core.ui.ui;

import org.example.core.domain.model.MenuItem;
import org.example.core.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderUI extends ConsoleUI {
    private final Map<MenuItem, Integer> cart;
    private final double totalPrice;

    public OrderUI(Map<MenuItem, Integer> cart, double totalPrice) {
        this.cart = cart;
        this.totalPrice = totalPrice;
    }

    @Override
    protected List<String> getFormattedLines() {
        List<String> lines = new ArrayList<>();
        lines.add("[ Orders ]");
        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
            lines.add(entry.getKey() + " x" + entry.getValue());
        }
        lines.add("");
        lines.add("[ Total ]");
        lines.add(String.format("W %.1f", totalPrice));
        lines.add("");
        lines.add("1. 주문      2. 메뉴판");
        return lines;
    }

    @Override
    public void view() {
        render();
    }
}
