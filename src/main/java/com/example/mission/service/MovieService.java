package com.example.mission.service;

import com.example.mission.model.dto.MovieDto;
import com.example.mission.model.dto.MovieRecommendDto;
import com.example.mission.model.dto.PopularMoviesDto;

import java.util.List;

public interface MovieService {
    MovieDto getMovieDetailById(Long id); // movie id 를 통해 영화 정보 반환

    List<MovieRecommendDto> getRecommendMoviesById(Long id);

    PopularMoviesDto getPopularMovies();
}
