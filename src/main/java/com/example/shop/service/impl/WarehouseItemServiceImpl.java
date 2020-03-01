package com.example.shop.service.impl;

import com.example.shop.enumaretions.ItemType;
import com.example.shop.model.WarehouseItem;
import com.example.shop.repository.WarehouseItemRepository;
import com.example.shop.service.WarehouseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseItemServiceImpl implements WarehouseItemService {

    @Autowired
    private WarehouseItemRepository warehouseItemRepository;

    @Override
    @Transactional
    public void add(WarehouseItem warehouseItem) {
        warehouseItemRepository.save(warehouseItem);
    }

    @Override
    @Transactional
    public void delete(WarehouseItem warehouseItem) {
        warehouseItemRepository.delete(warehouseItem);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        warehouseItemRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(WarehouseItem warehouseItem) {
      warehouseItemRepository.save(warehouseItem);
    }

    @Override
    @Transactional
    public WarehouseItem getById(long id) {
        return warehouseItemRepository.getById(id);
    }

    @Override
    @Transactional
    public List<WarehouseItem> getAll() {
        return warehouseItemRepository.findAll();
    }


}
