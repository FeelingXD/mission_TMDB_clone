package com.example.mission.common;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomException(ErrorCode e) {
        super(e.getMsg());
        this.errorCode = e;
    }
}
