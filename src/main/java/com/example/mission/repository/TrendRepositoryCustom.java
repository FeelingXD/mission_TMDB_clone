package com.example.mission.repository;

import com.example.mission.model.dto.MovieCardDto;

import java.util.List;

public interface TrendRepositoryCustom {
    List<MovieCardDto> getTodayMovieTrend();

    List<MovieCardDto> getThisWeekMovieTrend();
}
