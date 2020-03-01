package com.example.shop.service.impl;

import com.example.shop.model.Basket;
import com.example.shop.model.Item;
import com.example.shop.model.ItemInBasket;
import com.example.shop.repository.BasketRepository;
import com.example.shop.repository.ItemInBasketRepository;
import com.example.shop.service.BasketService;
import com.example.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemInBasketRepository itemInBasketRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(Basket basket) {
        basketRepository.save(basket);

    }

    @Transactional
    @Override
    public void deleteById(long id) {
        basketRepository.deleteById(id);

    }

    @Transactional
    @Override
    public void update(Basket basket) {
        basketRepository.save(basket);

    }

    @Transactional
    @Override
    public Basket getById(long id) {
        return basketRepository.getById(id);
    }

    @Override
    public Basket getByUserId(long id) {
        return basketRepository.getByUserId(id);
    }

    @Override
    @Transactional
    public List<Item> getItemsInBasket(Basket basket) {
        List<ItemInBasket> itemInBaskets = basket.getItems();
        List<Item> items = new ArrayList<>();
        for (ItemInBasket itemInBasket : itemInBaskets) {
            Item item = itemService.getById(itemInBasket.getItemId());
            entityManager.detach(item);
            item.setQuantity(itemInBasket.getQuantity());
            items.add(item);
        } return items;


    }

    @Override
    @Transactional
    public void addItemInBasket(Item item, Basket basket, String itemQuantity) {
        ItemInBasket itemInBasket=new ItemInBasket();
        itemInBasket.setItemId(item.getId());
        itemInBasket.setQuantity(Integer.parseInt(itemQuantity));
        basket.getItems().add(itemInBasket);
    }

    @Override
    @Transactional
    public void deleteItemInBasket(Basket basket, Item item) {

        ItemInBasket itemInBasket=itemInBasketRepository.getByItemId(item.getId());
        basket.getItems().remove(itemInBasket);
        itemInBasketRepository.delete(itemInBasket);

    }


}
