package com.selfdriven.aight.controller.api.advice;

import java.nio.file.AccessDeniedException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.selfdriven.aight.dto.ApiResponse;
import com.selfdriven.aight.enums.ResultCode;
import com.selfdriven.aight.exception.ApiException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ApiResponse apiException(ApiException e){
        return ApiResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ApiResponse.fail(ResultCode.INVALID_PARAMETER.getCode(), ResultCode.INVALID_PARAMETER.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponse httpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ApiResponse.fail(ResultCode.INVALID_PARAMETER.getCode(), ResultCode.INVALID_PARAMETER.getMessage());
    }

//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse runtimeException(RuntimeException e) {
        return ApiResponse.fail(ResultCode.UNKNOWN_ERROR.getCode(), ResultCode.UNKNOWN_ERROR.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ApiResponse accessDeniedException(AccessDeniedException e){
        return ApiResponse.fail(ResultCode.ACCESS_DENIED.getCode(), ResultCode.ACCESS_DENIED.getMessage());
    }

}
