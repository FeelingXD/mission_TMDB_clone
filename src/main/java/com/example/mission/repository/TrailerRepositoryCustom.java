package com.example.mission.repository;

import com.example.mission.model.dto.TrailerDto;

import java.util.List;

public interface TrailerRepositoryCustom {
    List<TrailerDto> getLatestTrailersByPopular();

    List<TrailerDto> getLatestTrailersByType(String platform);
}
