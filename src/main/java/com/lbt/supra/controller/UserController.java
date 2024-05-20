package com.lbt.supra.controller;

import com.lbt.supra.entity.UserEntity;
import com.lbt.supra.model.dto.UserCreationRequest;
import com.lbt.supra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers (){
        return userService.getAllUsers();
    }
}
