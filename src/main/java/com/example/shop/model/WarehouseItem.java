package com.example.shop.model;

import com.example.shop.enumaretions.ItemType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "warehouse")
public class WarehouseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private ItemType type;
    String name;
    double purchasePrice;
    double incomePercentage;
    int quantity;
}
