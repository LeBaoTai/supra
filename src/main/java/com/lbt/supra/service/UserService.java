package com.lbt.supra.service;

import com.lbt.supra.entity.UserEntity;
import com.lbt.supra.model.dto.UserCreationRequest;
import com.lbt.supra.model.dto.UserUpdateRequest;
import com.lbt.supra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity createUser(UserCreationRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dob(request.getDob())
                .build();

        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getOneUser(String uid) {
        return userRepository.findById(uid).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserEntity updateUser(String uid, UserUpdateRequest request) {

        UserEntity user = getOneUser(uid);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    public void deleteUser(String uid) {
        userRepository.deleteById(uid);
    }
}
