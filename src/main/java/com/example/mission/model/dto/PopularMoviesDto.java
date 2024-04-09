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
public class PopularMoviesDto {
    private List<MovieCardDto> streaming;
    private List<MovieCardDto> tv;
    private List<MovieCardDto> rental;
    private List<MovieCardDto> theater;

}
