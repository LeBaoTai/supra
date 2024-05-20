package com.lbt.supra.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserCreationRequest {

    @Setter(AccessLevel.NONE)
    String id;
    String username;

    String password;

    String firstName;

    String LastName;

    LocalDate dob;
}
