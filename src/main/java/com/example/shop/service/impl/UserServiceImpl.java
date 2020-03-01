package com.example.shop.service.impl;

import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
      @Autowired
     UserRepository userRepository;
    @Override
    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
       userRepository.delete(user);
    }

    @Override
    @Transactional
    public void update(User user) {
          userRepository.save(user);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userRepository.getById(id);
    }
}
