package com.lbt.supra.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException{
    ErrorCode errorCode;
}
