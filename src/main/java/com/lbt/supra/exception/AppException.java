package com.lbt.supra.exception;

import com.lbt.supra.enums.ErrorCode;
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
