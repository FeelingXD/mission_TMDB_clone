package com.example.mission.service;

import com.example.mission.model.dto.MovieDto;

public interface MovieService {
    MovieDto getMovieDetailById(Long id); // movie id 를 통해 영화 정보 반환
}
