package com.example.mission.repository;

import com.example.mission.model.dto.MovieCardDto;
import com.example.mission.model.dto.MovieRecommendDto;

import java.util.List;

public interface MovieRepositoryCustom {
    List<MovieRecommendDto> getRecommendMoviesById(Long id);

    List<MovieCardDto> getPopularMoviesByPlatform(String platform);
}
