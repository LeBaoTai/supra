package com.lbt.supra.exception;

import lombok.*;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED_EXCEPTION(9999, "Unauthorized Exception"),


    USER_EXISTED(1001, "User already exists!"),
    USER_NOT_EXISTED(1002, "User not exists!"),

    USERNAME_NOT_VALID(1003, "Username at least 6 character!"),
    PASSWORD_NOT_VALID(1004, "Password at least 6 character!"),

    ;
    private int code;
    private String message;

}
