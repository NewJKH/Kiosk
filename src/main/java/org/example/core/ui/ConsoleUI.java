package org.example.core.ui;

import java.util.List;

public abstract class ConsoleUI {

    public final void render() {
        List<String> lines = getContents();

        if (lines == null || lines.isEmpty()) return;

        int padding = 2;

        int maxVisualWidth = lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        int contentWidth = maxVisualWidth + padding * 2;

        drawTopBorder(contentWidth);
        drawContent(lines);
        drawBottomBorder(contentWidth);
    }

    private void drawTopBorder(int width) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("─".repeat(width));
        System.out.println();
    }

    private void drawBottomBorder(int width) {
        System.out.print("─".repeat(width));
        System.out.println();
    }

    private void drawContent(List<String> lines) {
        for (String line : lines) {
            System.out.println("+ " + line);
        }
    }

    protected abstract List<String> getContents();
}
