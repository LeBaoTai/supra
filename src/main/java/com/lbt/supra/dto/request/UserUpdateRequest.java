package com.lbt.supra.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

    @Size(min = 6, message = "PASSWORD_NOT_VALID")
    String password;

    String firstName;

    String LastName;

    LocalDate dob;
}
