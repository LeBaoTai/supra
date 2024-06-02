package com.lbt.supra.mapper;

import com.lbt.supra.dto.request.PermissionRequest;
import com.lbt.supra.dto.response.PermissionResponse;
import com.lbt.supra.entity.PermissionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionEntity toPermissionEntity(PermissionRequest request);
    PermissionResponse toPermissionResponse(PermissionEntity entity);

}
