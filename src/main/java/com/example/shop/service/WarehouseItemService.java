package com.example.shop.service;

import com.example.shop.enumaretions.ItemType;
import com.example.shop.model.WarehouseItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseItemService {
    void add(WarehouseItem warehouseItem);

    void delete(WarehouseItem warehouseItem);

    void deleteById(long id);

    void update(WarehouseItem warehouseItem);

    WarehouseItem getById(long id);

    List<WarehouseItem>getAll();




}
