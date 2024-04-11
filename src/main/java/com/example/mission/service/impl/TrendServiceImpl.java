package com.example.mission.service.impl;

import com.example.mission.model.dto.MovieTrendDto;
import com.example.mission.repository.TrendRepository;
import com.example.mission.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrendServiceImpl implements TrendService {
    private final TrendRepository trendRepository;

    @Override
    public MovieTrendDto getMovieTrends() {
        var today = trendRepository.getTodayMovieTrend();
        var thisWeek = trendRepository.getThisWeekMovieTrend();

        return MovieTrendDto.builder()
                .today(today)
                .thisWeek(thisWeek)
                .build();
    }

}
