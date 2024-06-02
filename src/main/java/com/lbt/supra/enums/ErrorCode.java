package com.lbt.supra.enums;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),

    USER_EXISTED(1001, "User already exists!", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1002, "User not exists!", HttpStatus.NOT_FOUND),

    USERNAME_NOT_VALID(1003, "Username at least 6 character!", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_VALID(1004, "Password at least 6 character!", HttpStatus.BAD_REQUEST),

    ;

    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;

}
