package com.example.shop.service.impl;

import com.example.shop.model.Item;
import com.example.shop.model.WarehouseItem;
import com.example.shop.repository.ItemRepository;
import com.example.shop.repository.WarehouseItemRepository;
import com.example.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private WarehouseItemRepository warehouseItemRepository;

    @Override
    @Transactional
    public void add(Item item) {
        WarehouseItem warehouseItem=warehouseItemRepository.getByNameAndType(item.getName(),item.getType());
        double price=warehouseItem.getPurchasePrice()+(warehouseItem.getPurchasePrice()/100*warehouseItem.getIncomePercentage());
        item.setPrice(price);
        warehouseItem.setQuantity(warehouseItem.getQuantity()-item.getQuantity());
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void update(Item item) {
       itemRepository.save(item);
    }

    @Override
    @Transactional
    public void delete(Item item) {
       itemRepository.delete(item);
    }

    @Override
    @Transactional
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    @Transactional
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        itemRepository.deleteById(id);

    }
}
