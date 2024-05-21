package com.lbt.supra.controller;

import com.lbt.supra.entity.UserEntity;
import com.lbt.supra.model.dto.UserCreationRequest;
import com.lbt.supra.model.dto.UserUpdateRequest;
import com.lbt.supra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserEntity> getAllUsers (){
        return userService.getAllUsers();
    }

    @GetMapping("/{uid}")
    public UserEntity getOneUser(@PathVariable("uid") String uid) {
        return userService.getOneUser(uid);
    }

    @PutMapping("/{uid}")
    public UserEntity getOneUserByUid(@PathVariable("uid") String uid,@RequestBody UserUpdateRequest request) {
        return userService.updateUser(uid, request);
    }
}
