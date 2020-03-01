package com.example.shop;

import com.example.shop.enumaretions.UserRole;
import com.example.shop.model.Basket;
import com.example.shop.model.Item;
import com.example.shop.model.ItemInBasket;
import com.example.shop.model.User;
import com.example.shop.service.BasketService;
import com.example.shop.service.ItemInBasketService;
import com.example.shop.service.ItemService;
import com.example.shop.service.UserService;
import com.example.shop.service.impl.BasketServiceImpl;
import com.example.shop.service.impl.ItemInBasketServiceImpl;
import com.example.shop.service.impl.ItemServiceImpl;
import com.example.shop.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ShopApplication.class, args);








    }


}
