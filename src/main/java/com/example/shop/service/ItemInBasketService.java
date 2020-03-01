package com.example.shop.service;

import com.example.shop.model.ItemInBasket;

public interface ItemInBasketService {

    void add(ItemInBasket itemInBasket);

    void update(ItemInBasket itemInBasket);

    void delete(ItemInBasket itemInBasket);

    ItemInBasket getById(long id);

}
