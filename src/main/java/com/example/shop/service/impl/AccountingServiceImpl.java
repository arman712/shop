package com.example.shop.service.impl;

import com.example.shop.model.Item;
import com.example.shop.model.WarehouseItem;
import com.example.shop.repository.ItemRepository;
import com.example.shop.repository.WarehouseItemRepository;
import com.example.shop.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private WarehouseItemRepository warehouseItemRepository;

    @Override
    public Double getProfit() {
        Double profit = 0D;
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            WarehouseItem warehouseItem = warehouseItemRepository.getByNameAndType(item.getName(), item.getType());
            double difference = item.getPrice() - warehouseItem.getPurchasePrice();
            profit += item.getSoldQuantity() * difference;

        }
        return profit;

    }
}
