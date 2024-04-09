package com.example.mission.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class LatestTrailersDto {
    private List<TrailerDto> popular;
    private List<TrailerDto> streaming;
    private List<TrailerDto> tv;
    private List<TrailerDto> rental;
    private List<TrailerDto> theater;


}
