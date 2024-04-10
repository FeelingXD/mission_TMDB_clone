package com.example.mission.controller;

import com.example.mission.model.dto.MovieTrendDto;
import com.example.mission.service.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/trends")
public class TrendController {
    private final TrendService trendService;
    @GetMapping
    public MovieTrendDto getMovieTrends(){
        return trendService.getMovieTrends();
    }
}
