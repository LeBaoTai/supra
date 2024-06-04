package com.lbt.supra.service;

import com.lbt.supra.dto.request.UserCreationRequest;
import com.lbt.supra.dto.request.UserUpdateRequest;
import com.lbt.supra.dto.response.UserResponse;
import com.lbt.supra.entity.RoleEntity;
import com.lbt.supra.entity.UserEntity;
import com.lbt.supra.enums.Role;
import com.lbt.supra.exception.AppException;
import com.lbt.supra.enums.ErrorCode;
import com.lbt.supra.mapper.UserMapper;
import com.lbt.supra.repository.RoleRepository;
import com.lbt.supra.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;

    RoleRepository roleRepository;


    public UserResponse createUser(UserCreationRequest request) {

        UserEntity user = userMapper.toUserEntity(request);

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> role = new HashSet<>();
        role.add(Role.USER.name());

//        user.setRoles(role);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUsers() {
        log.info("in method get user");
        return userRepository.findAll()
                .stream()
                .map((userMapper::toUserResponse))
                .toList();
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getOneUser(String uid) {
        log.info("in method get one user");
        return userMapper.toUserResponse(
                userRepository
                        .findById(uid)
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse getMyInfo() {
        SecurityContext context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(String uid, UserUpdateRequest request) {

        UserEntity user = userRepository
                .findById(uid)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user, request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        List<RoleEntity> roles = roleRepository.findAllById(request.getRoles());

        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String uid) {
        userRepository.deleteById(uid);
    }
}
