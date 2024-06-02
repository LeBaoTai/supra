package com.lbt.supra.mapper;


import com.lbt.supra.dto.request.RoleRequest;
import com.lbt.supra.dto.response.RoleResponse;
import com.lbt.supra.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    RoleEntity toRoleEntity(RoleRequest request);

    RoleResponse toRoleResponse(RoleEntity entity);
}
