package com.example.mission.service.impl;

import com.example.mission.model.dto.LatestTrailersDto;
import com.example.mission.model.dto.TrailerDto;
import com.example.mission.model.entity.PlatformType;
import com.example.mission.model.type.Platform;
import com.example.mission.repository.TrailerRepository;
import com.example.mission.service.TrailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrailerServiceImpl implements TrailerService {
    private final TrailerRepository trailerRepository;
    @Override
    public LatestTrailersDto getLatestTrailers() {
        var popular=trailerRepository.getLatestTrailersByPopular();
        var tv=trailerRepository.getLatestTrailersByType(Platform.TV.name());
        var streaming=trailerRepository.getLatestTrailersByType(Platform.STREAMING.name());
        var rental=trailerRepository.getLatestTrailersByType(Platform.RENTAL.name());
        var theater=trailerRepository.getLatestTrailersByType(Platform.THEATER.name());

        return LatestTrailersDto.builder()
                .popular(popular.stream().map(TrailerDto::objToTrailerDto).toList())
                .tv(tv.stream().map(TrailerDto::objToTrailerDto).toList())
                .streaming(streaming.stream().map(TrailerDto::objToTrailerDto).toList())
                .rental(rental.stream().map(TrailerDto::objToTrailerDto).toList())
                .theater(theater.stream().map(TrailerDto::objToTrailerDto).toList())
                .build();
    }
}
