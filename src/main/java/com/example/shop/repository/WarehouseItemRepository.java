package com.example.shop.repository;

import com.example.shop.enumaretions.ItemType;
import com.example.shop.model.WarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseItemRepository extends JpaRepository<WarehouseItem,Long> {

    WarehouseItem getById(long id);

    void deleteById(long id);

    WarehouseItem getByNameAndType(String name, ItemType itemType);


}
