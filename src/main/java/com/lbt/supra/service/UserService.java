package com.lbt.supra.service;

import com.lbt.supra.dto.request.UserCreationRequest;
import com.lbt.supra.dto.request.UserUpdateRequest;
import com.lbt.supra.dto.response.UserResponse;
import com.lbt.supra.entity.UserEntity;
import com.lbt.supra.exception.AppException;
import com.lbt.supra.exception.ErrorCode;
import com.lbt.supra.mapper.UserMapper;
import com.lbt.supra.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;


    public UserResponse createUser(UserCreationRequest request) {

        UserEntity user = userMapper.toUserEntity(request);

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map((userMapper::toUserResponse))
                .toList();
    }

    public UserResponse getOneUser(String uid) {
        return userMapper.toUserResponse(
                userRepository
                        .findById(uid)
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    public UserResponse updateUser(String uid, UserUpdateRequest request) {

        UserEntity user = userRepository
                .findById(uid)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String uid) {
        userRepository.deleteById(uid);
    }
}
