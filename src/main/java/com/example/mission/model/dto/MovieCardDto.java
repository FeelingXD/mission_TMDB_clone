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
public class MovieCardDto {

    private Long id;
    private String title;
    private LocalDateTime releaseDate;
    private String posterPath;
    private Integer UserScore;

    public MovieCardDto fromEntity(Movie movie){
        return MovieCardDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .releaseDate(movie.getReleaseDate())
                .posterPath(movie.getPosterPath())
                .UserScore((int)(movie.getVoteAverage()*10))
                .build();
    }

}
