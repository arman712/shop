package com.example.shop.repository;

import com.example.shop.model.Basket;
import com.example.shop.service.BasketService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
    Basket getById(long id);
    void deleteById(long id);
    Basket getByUserId(long id);

}
