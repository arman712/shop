package com.example.shop.controller;

import com.example.shop.enumaretions.UserRole;
import com.example.shop.model.User;
import com.example.shop.model.WarehouseItem;
import com.example.shop.service.UserService;
import com.example.shop.service.WarehouseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping(value = "/warehouse/{adminId}")
public class WarehouseController {
    @Autowired
    private UserService userService;
    @Autowired
    private WarehouseItemService warehouseItemService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getItemsInWarehouse(@PathVariable String adminId){

        User user=userService.getById(Long.parseLong(adminId));
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(user.getUserRole()!= UserRole.ADMIN){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<WarehouseItem>warehouseItems=warehouseItemService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(warehouseItems);
    }
}
