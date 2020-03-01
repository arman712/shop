package com.example.shop.controller;

import com.example.shop.exceptions.NotEnoughBalanceException;
import com.example.shop.model.Item;
import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.ShopService;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;


    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public ResponseEntity buy(@PathVariable String id){

        User user=userService.getById(Long.parseLong(id));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            shopService.buy(user);
            return ResponseEntity.ok().build();
        } catch (NotEnoughBalanceException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }


    }
}
