package com.cachedata.cachedata.controller;

import com.cachedata.cachedata.entity.User;
import com.cachedata.cachedata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    final UserService userService;

    @GetMapping
    public String autoCreateUser(){
        userService.autoCreateData();
        return "ok";
    }

    @GetMapping("all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
}
