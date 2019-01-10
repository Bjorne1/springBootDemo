package com.example.user.controller;

import com.example.user.bean.User;
import com.example.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/user/{id}")
    public User get(@PathVariable int id) {
        return userDao.getById(id);
    }
}
