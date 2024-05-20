package com.lbt.supra.service;

import com.lbt.supra.entity.UserEntity;
import com.lbt.supra.model.dto.UserCreationRequest;
import com.lbt.supra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity createUser(UserCreationRequest request) {
        UserEntity user = new UserEntity();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
