package com.example.shop.model;

import com.example.shop.enumaretions.ItemType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "store")
public  class Item {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private ItemType type;
    private String name;
    private double price;
    private int quantity;
    private int soldQuantity;


}
