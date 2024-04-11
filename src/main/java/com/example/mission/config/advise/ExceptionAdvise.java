package com.example.mission.config.advise;

import com.example.mission.common.CustomException;
import com.example.mission.common.ErrorCode;
import com.github.feelingxd.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionAdvise {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Void>> customExceptionHandler(CustomException e) {
        return ApiResponse.builder().code(e.getErrorCode()).toEntity();
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse<Void>>  noHandlerFoundExceptionHandler(NoHandlerFoundException e){
        return ApiResponse.builder().code(ErrorCode.WRONG_URL_REQUESTED).toEntity();
    }
}
