package org.example.core.domain.repository;

import org.example.core.domain.model.Category;
import org.example.core.domain.model.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MenuRepository {
    private final Map<Category, List<MenuItem>> items = new HashMap<>();

    public MenuRepository() {
        items.put(Category.BURGERS,
                List.of(new MenuItem("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9),
                        new MenuItem("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9),
                        new MenuItem("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9),
                        new MenuItem("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4))
        );

        items.put(Category.DRINKS,
                List.of(new MenuItem("Coca-Cola", "톡 쏘는 청량감의 클래식 코카콜라", 2.0),
                        new MenuItem("Lemonade", "상큼한 레몬이 들어간 천연 과일 음료", 2.5),
                        new MenuItem("Milkshake", "바닐라, 초코, 스트로베리 중 택 1", 3.5),
                        new MenuItem("Iced Tea", "달콤하고 시원한 얼음 홍차", 2.3))
        );
        items.put(Category.DESSERTS,
                List.of(new MenuItem("Custard", "부드럽고 달콤한 바닐라 커스터드 아이스크림", 3.0),
                        new MenuItem("Brownie", "진한 초콜릿이 가득한 촉촉한 브라우니", 3.2),
                        new MenuItem("Cookie", "겉은 바삭, 속은 촉촉한 초코칩 쿠키", 2.5),
                        new MenuItem("Ice Cream Sandwich", "쿠키 사이에 아이스크림이 샌드된 디저트", 3.7))
        );
    }
    public List<MenuItem> getMenuItemsByCategory(Category category){
        return items.get(category);
    }

    public Optional<MenuItem> getItemByName(String name) {
        return items.values().stream()
                .flatMap(List::stream)
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
