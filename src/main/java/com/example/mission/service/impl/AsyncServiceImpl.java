package com.example.mission.service.impl;

import com.example.mission.common.CustomException;
import com.example.mission.common.ErrorCode;
import com.example.mission.model.entity.Vote;
import com.example.mission.repository.MovieRepository;
import com.example.mission.repository.VoteRepository;
import com.example.mission.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncServiceImpl implements AsyncService {
    private final VoteRepository voteRepository;
    private final MovieRepository movieRepository;

    @Override
    public void createVote(final Long id, Integer voteScore) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.MOVIE_NOT_FOUND));
        var currentVote = Vote.builder()
                .movie(movie)
                .voteScore(voteScore)
                .build();
        voteRepository.save(currentVote);
    }
}
