package com.example.mission.service.impl;

import com.example.mission.model.dto.MovieDto;
import com.example.mission.model.dto.MovieRecommendDto;
import com.example.mission.repository.MovieRepository;
import com.example.mission.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public MovieDto getMovieDetailById(Long id) {
        var result = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디에 해당하는 영화가 존재하지 않습니다."));
        return MovieDto.fromEntity(result);
    }

    @Override
    public List<MovieRecommendDto> getRecommendMoviesById(Long id) {
        return movieRepository.getRecommendMoviesById(id);
    }
}
