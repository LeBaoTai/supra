package com.lbt.supra.service;

import com.lbt.supra.dto.request.PermissionRequest;
import com.lbt.supra.dto.response.PermissionResponse;
import com.lbt.supra.entity.PermissionEntity;
import com.lbt.supra.mapper.PermissionMapper;
import com.lbt.supra.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse createPermission(PermissionRequest request) {
        PermissionEntity permission = permissionMapper.toPermissionEntity(request);
        permissionRepository.save(permission);

        return PermissionResponse.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public List<PermissionResponse> getAllPermissions() {
        List<PermissionEntity> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void deletePermission(String permissionName) {
        permissionRepository.deleteById(permissionName);
    }
}
