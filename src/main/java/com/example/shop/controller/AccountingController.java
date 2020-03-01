package com.example.shop.controller;

import com.example.shop.enumaretions.UserRole;
import com.example.shop.model.User;
import com.example.shop.service.AccountingService;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounting/{adminId}")
public class AccountingController {
    @Autowired
    private AccountingService accountingService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getProfit(@PathVariable String adminId){
        User user=userService.getById(Long.parseLong(adminId));
        if(user==null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(user.getUserRole()!= UserRole.ADMIN){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Double profit=accountingService.getProfit();
        return ResponseEntity.status(HttpStatus.OK).body(profit);

    }

}
