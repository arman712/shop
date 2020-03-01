package com.example.shop.service.impl;

import com.example.shop.model.ItemInBasket;
import com.example.shop.repository.ItemInBasketRepository;
import com.example.shop.service.ItemInBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemInBasketServiceImpl implements ItemInBasketService {
    @Autowired
    ItemInBasketRepository itemInBasketRepository;
    @Override
    @Transactional
    public void add(ItemInBasket itemInBasket) {
        itemInBasketRepository.save(itemInBasket);
    }

    @Override
    public void update(ItemInBasket itemInBasket) {
        itemInBasketRepository.save(itemInBasket);
    }

    @Override
    public void delete(ItemInBasket itemInBasket) {
         itemInBasketRepository.delete(itemInBasket);
    }

    @Override
    public ItemInBasket getById(long id) {
        return itemInBasketRepository.getById(id);
    }
}
