package com.example.mission.config.advise;

import com.example.mission.common.CustomException;
import com.example.mission.common.ErrorCode;
import com.github.feelingxd.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> processValidationError(MethodArgumentNotValidException e){
        StringBuilder builder=new StringBuilder();
        for (FieldError fieldError:e.getBindingResult().getFieldErrors()){
            builder.append("[").append(fieldError.getField()).append("](은)는");
            builder.append(fieldError.getDefaultMessage());
            builder.append(String.format("입력된 값 [ %s ]",fieldError.getRejectedValue()));
        }

        return ApiResponse.builder()
                .code(ErrorCode.VALIDATION_ERROR)
                .data(builder)
                .toEntity();
    }
}
