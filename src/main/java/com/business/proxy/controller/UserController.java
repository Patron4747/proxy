package com.business.proxy.controller;

import com.business.proxy.model.User;
import com.business.proxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }
}
