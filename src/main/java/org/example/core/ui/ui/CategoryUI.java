package org.example.core.ui.ui;

import org.example.core.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class CategoryUI extends ConsoleUI {

    private final String title;
    private final List<String> menuItems;

    public CategoryUI(String title, List<String> menuItems) {
        this.title = title;
        this.menuItems = menuItems;
    }

    @Override
    protected List<String> getFormattedLines() {
        List<String> lines = new ArrayList<>();
        lines.add("[ " + title + " ]");

        for (int i = 0; i < menuItems.size(); i++) {
            lines.add((i + 1) + ". " + menuItems.get(i));
        }

        lines.add("");
        lines.add("0. 종료");
        return lines;
    }

    @Override
    public void view() {
        render();
    }
}
