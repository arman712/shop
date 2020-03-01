package com.example.shop.service;

import com.example.shop.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    void add(Item item);

    void update(Item item);

    void delete(Item item);

    Item getById(long id);

    List<Item> getAll();

    void deleteById(long id);


}
