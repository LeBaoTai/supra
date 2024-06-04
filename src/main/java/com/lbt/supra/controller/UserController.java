package com.lbt.supra.controller;

import com.lbt.supra.dto.request.UserCreationRequest;
import com.lbt.supra.dto.request.UserUpdateRequest;
import com.lbt.supra.dto.response.ApiResponse;
import com.lbt.supra.dto.response.UserResponse;
import com.lbt.supra.service.UserService;
import com.nimbusds.jose.proc.SecurityContext;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());

        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));


        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{uid}")
    public ApiResponse<UserResponse> getOneUser(@PathVariable("uid") String uid) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getOneUser(uid))
                .build();
    }

    @GetMapping("/myInfo")
    public ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }


    @PutMapping("/{uid}")
    public ApiResponse<UserResponse> updateUser(@PathVariable("uid") String uid, @RequestBody @Valid UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(uid, request))
                .build();
    }

    @DeleteMapping("/{uid}")
    ApiResponse<String> deleteOneUser(@PathVariable("uid") String uid) {
        userService.deleteUser(uid);
        return ApiResponse.<String>builder()
                .message("User Deleted")
                .build();
    }
}
