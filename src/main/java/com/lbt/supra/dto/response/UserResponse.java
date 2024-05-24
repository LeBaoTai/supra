package com.lbt.supra.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    @Setter(AccessLevel.NONE)
    String id;
    @Setter(AccessLevel.NONE)
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
