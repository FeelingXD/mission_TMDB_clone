package com.example.mission.controller;

import com.example.mission.model.dto.MovieDto;
import com.example.mission.model.dto.MovieRecommendDto;
import com.example.mission.model.dto.PopularMoviesDto;
import com.example.mission.model.dto.VoteResultDto;
import com.example.mission.model.dto.form.VoteForm;
import com.example.mission.service.MovieService;
import com.example.mission.service.VoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/movie")
public class MovieController {
    private final MovieService movieService;
    private final VoteService voteService;

    //영화 상세 API
    @GetMapping("/{id}")
    public MovieDto getMovieDetailById(@PathVariable long id) {
        return movieService.getMovieDetailById(id);
    }

    @GetMapping("/{id}/recommend")
    public List<MovieRecommendDto> getRecommendMoviesById(@PathVariable long id) {
        return movieService.getRecommendMoviesById(id);
    }

    @GetMapping("/popular")
    public PopularMoviesDto getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @PostMapping("/{id}/vote")
    public VoteResultDto voteMovie(@PathVariable long id, @Valid @RequestBody VoteForm form) {
        voteService.createVote(id, form.getVoteScore());
        return VoteResultDto.builder()
                .movieId(id)
                .voteScore(form.getVoteScore())
                .build();
    }
}
