package com.lbt.supra.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserUpdateRequest {

    String password;

    String firstName;

    String LastName;

    LocalDate dob;
}
