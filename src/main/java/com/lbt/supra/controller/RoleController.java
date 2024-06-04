package com.lbt.supra.controller;

import com.lbt.supra.dto.response.ApiResponse;
import com.lbt.supra.dto.request.RoleRequest;
import com.lbt.supra.dto.response.RoleResponse;
import com.lbt.supra.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {

    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> createPermission(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.createRole(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAllRole())
                .build();
    }

    @DeleteMapping("/{rid}")
    ApiResponse<String> deleteRole(@PathVariable("rid") String rid) {
        roleService.deleteRole(rid);
        return ApiResponse.<String>builder()
                .result("Role deleted")
                .build();
    }
}
