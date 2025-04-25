package org.example.core.ui;

import org.example.pro.level2.CustomerType;

import java.util.ArrayList;
import java.util.List;

public class CustomerUI extends ConsoleUI{

    @Override
    protected List<String> getFormattedLines() {
        int index = 1;
        List<String> lines = new ArrayList<>();
        lines.add("[ 할인 정보를 입력해주세요. ]");
        for ( CustomerType type : CustomerType.values() ){
            lines.add(index+". "+type.getLabel()+" ( "+type.getDiscount()*100+"% )");
            index++;
        }
        return lines;
    }

    public void view() {
        render();
    }
}
