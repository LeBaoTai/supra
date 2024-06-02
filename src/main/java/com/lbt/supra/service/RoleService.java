package com.lbt.supra.service;

import com.lbt.supra.dto.request.RoleRequest;
import com.lbt.supra.dto.response.RoleResponse;
import com.lbt.supra.entity.PermissionEntity;
import com.lbt.supra.entity.RoleEntity;
import com.lbt.supra.mapper.RoleMapper;
import com.lbt.supra.repository.PermissionRepository;
import com.lbt.supra.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        RoleEntity roleEntity = roleMapper.toRoleEntity(request);
        List<PermissionEntity> allPermissions = permissionRepository.findAllById(request.getPermissions());
        roleEntity.setPermissions(new HashSet<>(allPermissions));
        roleRepository.save(roleEntity);

        return roleMapper.toRoleResponse(roleEntity);
    }

    public List<RoleResponse> getAllRole() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void deleteRole(String roleId) {
        roleRepository.deleteById(roleId);
    }
}
