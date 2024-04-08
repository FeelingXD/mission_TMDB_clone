package com.example.mission.controller;

import com.example.mission.model.dto.MovieDto;
import com.example.mission.model.dto.MovieRecommendDto;
import com.example.mission.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MovieController {
    private final MovieService movieService;

    //영화 상세 API
    @GetMapping("/movie/{id}")
    public MovieDto getMovieDetailById(@PathVariable long id) {
        return movieService.getMovieDetailById(id);
    }

    @GetMapping("/movie/{id}/recommend")
    public List<MovieRecommendDto> getRecommendMoviesById(@PathVariable long id){return movieService.getRecommendMoviesById(id);}
}
