package com.lbt.supra.mapper;


import com.lbt.supra.dto.request.PermissionRequest;
import com.lbt.supra.dto.request.UserCreationRequest;
import com.lbt.supra.dto.request.UserUpdateRequest;
import com.lbt.supra.dto.response.UserResponse;
import com.lbt.supra.entity.PermissionEntity;
import com.lbt.supra.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget UserEntity user, UserUpdateRequest request);
    UserEntity toUserEntity(UserCreationRequest request);
    UserResponse toUserResponse(UserEntity user);

}
