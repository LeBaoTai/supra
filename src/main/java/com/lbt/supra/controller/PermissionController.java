package com.lbt.supra.controller;

import com.lbt.supra.dto.response.ApiResponse;
import com.lbt.supra.dto.request.PermissionRequest;
import com.lbt.supra.dto.response.PermissionResponse;
import com.lbt.supra.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest request) {
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.createPermission(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAllPermissions())
                .build();
    }

    @DeleteMapping("/{pid}")
    ApiResponse<String> deletePermission(@PathVariable("pid") String pid) {
        permissionService.deletePermission(pid);
        return ApiResponse.<String>builder()
                .result("Permission deleted")
                .build();
    }
}
