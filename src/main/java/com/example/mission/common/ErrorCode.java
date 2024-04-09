package com.example.mission.common;

import com.github.feelingxd.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode implements Code {
    MOVIE_NOT_FOUND(HttpStatus.BAD_REQUEST,"ID에 해당하는 영화를 찾을 수 없습니다.");
    private final HttpStatus status;
    private final String msg;
}
