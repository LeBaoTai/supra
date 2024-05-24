package com.lbt.supra.exception;

import com.lbt.supra.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException e) {
        ApiResponse response = ApiResponse.builder()
                .code(ErrorCode.UNAUTHORIZED_EXCEPTION.getCode())
                .message(ErrorCode.UNAUTHORIZED_EXCEPTION.getMessage())
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();


        ApiResponse response = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String enumKey = e.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.valueOf(enumKey);

        ApiResponse response = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();


        return ResponseEntity.badRequest().body(response);
    }
}
