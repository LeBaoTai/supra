package com.lbt.supra.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    String name;
    String description;

    Set<PermissionResponse> permissions;
}
