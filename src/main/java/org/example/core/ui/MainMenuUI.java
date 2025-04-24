package org.example.core.ui;

import java.util.List;

public class MainMenuUI extends ConsoleUI {



    @Override
    protected List<String> getContents() {
        return List.of(
                "오늘도 나는",
                "스파르타의 과제를",
                "하지않고 놀고있다."
        );
    }
}
