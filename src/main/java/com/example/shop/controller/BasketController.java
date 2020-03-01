package com.example.shop.controller;

import com.example.shop.model.Basket;
import com.example.shop.model.Item;
import com.example.shop.model.User;
import com.example.shop.service.BasketService;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
   public ResponseEntity getBasket(@PathVariable String id){
       User user=userService.getById(Long.parseLong(id));
       if(user==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       Basket basket=basketService.getByUserId(user.getId());

       return ResponseEntity.ok(basketService.getItemsInBasket(basket));
   }

   @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public ResponseEntity addItemInBasket(@PathVariable String id, @RequestBody Item item, @RequestParam String itemQuantity){

        User user=userService.getById(Long.parseLong(id));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Basket basket=basketService.getByUserId(user.getId());
        basketService.addItemInBasket(item,basket,itemQuantity);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

   }

   @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteItemInBasket(@PathVariable String id,@RequestBody Item item){
        User user=userService.getById(Long.parseLong(id));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Basket basket=basketService.getByUserId(user.getId());
        basketService.deleteItemInBasket(basket,item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

   }

}
