package com.lbt.supra.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    String name;
    String description;
    Set<String> permissions;
}
