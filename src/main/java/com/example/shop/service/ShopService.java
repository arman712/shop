package com.example.shop.service;

import com.example.shop.exceptions.NotEnoughBalanceException;
import com.example.shop.model.Item;
import com.example.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {

    void buy(User user) throws NotEnoughBalanceException;
}
