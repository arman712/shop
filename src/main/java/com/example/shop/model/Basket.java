package com.example.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER )
    private List<ItemInBasket> items;
}
