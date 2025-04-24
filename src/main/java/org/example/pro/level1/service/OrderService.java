package org.example.pro.level1.service;

import org.example.core.domain.repository.CartRepository;
import org.example.core.domain.repository.MenuRepository;

public class OrderService {
    private final CartRepository cartRepository;
    private final MenuRepository menuRepository;

    public OrderService(CartRepository cartRepository, MenuRepository menuRepository) {
        this.cartRepository = cartRepository;
        this.menuRepository = menuRepository;
    }

    public void purchase(){
        for ( String name : cartRepository.getItemsName() ){
            int ea = cartRepository.getEaByName(name);
        }
    }

}
