package com.example.shop.service;

import com.example.shop.model.Basket;
import com.example.shop.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {

    void add(Basket basket);

    void deleteById(long id);

    void update(Basket basket);

    Basket getById(long id);

    Basket getByUserId(long id);

    List<Item> getItemsInBasket(Basket basket);

    void addItemInBasket(Item item,Basket basket,String itemQuantity);

    void deleteItemInBasket(Basket basket, Item item);
}
