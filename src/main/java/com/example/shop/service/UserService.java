package com.example.shop.service;

import com.example.shop.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void add(User user);

    void delete(User user);

    void update(User user);

    User getById(long id);
}
