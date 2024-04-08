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
public class MovieDto {
    private Long id;
    private String title;
    private String posterPath;
    private String status;
    private String genre;
    private String overview;
    private Long budget;
    private Long revenue;
    private String productionCountries;
    private String productionCompanies;
    private Integer voteRate;
    private LocalDateTime releaseDate;
    private TrailerDto trailerInfo;
    private String language;

    public static MovieDto fromEntity(Movie movie) { // todo : Movie -> MovieDto
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .posterPath(movie.getPosterPath())
                .status(movie.getStatus())
                .genre(movie.getGenre())
                .overview(movie.getOverview())
                .budget(movie.getBudget())
                .revenue(movie.getRevenue())
                .productionCountries(movie.getProductionCountries())
                .productionCompanies(movie.getProductionCompanies())
                .voteRate((int) (movie.getVoteAverage() * 10))
                .releaseDate(movie.getReleaseDate())
                .language(movie.getLanguage().strip())
                .trailerInfo(TrailerDto.fromEntity(movie.getTrailer()))
                .build();
    }
}
