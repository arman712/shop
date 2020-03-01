package com.example.shop.model;

import com.example.shop.enumaretions.ItemType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.util.List;



@Entity
@Data
public class ItemInBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long itemId;
    int quantity;

}
