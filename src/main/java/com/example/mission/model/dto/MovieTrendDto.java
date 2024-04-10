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
public class MovieTrendDto {
    List<MovieCardDto> today;
    List<MovieCardDto> thisWeek;
}
