package com.example.shop.controller;

import com.example.shop.enumaretions.UserRole;
import com.example.shop.model.Item;
import com.example.shop.model.User;
import com.example.shop.service.ItemService;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getItemsInStore() {
        List<Item> items = itemService.getAll();
        return ResponseEntity.ok(items);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public ResponseEntity addItemInStore(@RequestBody Item item, @PathVariable String id) {


        User user = userService.getById(Long.parseLong(id));
        if (user == null || item == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else if (user.getUserRole() == UserRole.ADMIN) {
            itemService.add(item);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteItemInStore(@PathVariable String id, @RequestParam(name = "user_id") String user_id) {
        User user = userService.getById(Long.parseLong(user_id));
        if (user == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (user.getUserRole() == UserRole.ADMIN) {
            itemService.deleteById(Long.parseLong(id));
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateItemInStore(@RequestBody Item item, @RequestParam(name = "id") String id) {

        User user = userService.getById(Long.parseLong(id));

        if (user == null || item == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else if (user.getUserRole() == UserRole.ADMIN) {

            itemService.update(item);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }


}
