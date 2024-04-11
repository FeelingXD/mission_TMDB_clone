package com.example.mission.model.dto;

import com.example.mission.model.entity.Movie;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
public class MovieRecommendDto {
    private Long id;
    private String title;
    private LocalDateTime releaseDate;
    private String posterPath;
    private Integer userScore;

    public static MovieRecommendDto fromEntity(Movie movie) {
        return MovieRecommendDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .posterPath(movie.getPosterPath())
                .userScore((int) (movie.getVoteAverage() * 10))
                .build();
    }
}
