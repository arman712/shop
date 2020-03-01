package com.example.shop.model;



import com.example.shop.enumaretions.UserRole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated
    private UserRole userRole;
    private double balance;


}
