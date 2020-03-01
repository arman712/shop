package com.example.shop.service.impl;

import com.example.shop.exceptions.NotEnoughBalanceException;
import com.example.shop.model.Basket;
import com.example.shop.model.Item;
import com.example.shop.model.ItemInBasket;
import com.example.shop.model.User;
import com.example.shop.repository.*;
import com.example.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemInBasketRepository itemInBasketRepository;


    @Transactional
    @Override
    public void buy(User user) throws NotEnoughBalanceException {

        Basket basket = basketRepository.getByUserId(user.getId());
        List<ItemInBasket> itemInBaskets = basket.getItems();
        System.out.println(itemInBaskets);

        double price = 0D;
        for (ItemInBasket itemInBasket : itemInBaskets) {
            Item item = itemRepository.getById(itemInBasket.getItemId());
            price += (item.getPrice() * itemInBasket.getQuantity());
        }
        if (user.getBalance() >= price) {
            for (ItemInBasket itemInBasket : itemInBaskets) {
                Item item = itemRepository.getById(itemInBasket.getItemId());
                item.setQuantity(item.getQuantity() - itemInBasket.getQuantity());
                item.setSoldQuantity(item.getSoldQuantity()+itemInBasket.getQuantity());
            }
            for (ItemInBasket itemInBasket : basket.getItems()) {
                itemInBasketRepository.delete(itemInBasket);
            }
            basket.getItems().clear();
            user.setBalance(user.getBalance() - price);


            } else {
               throw new NotEnoughBalanceException();
             }

    }
}
