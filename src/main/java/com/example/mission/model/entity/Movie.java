package com.example.mission.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Movie {
    @Id
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(name = "poster_path")
    private String posterPath;

    private String status;

    private String genre;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String overview;

    private Long budget;

    private Long revenue;

    @Column(name = "production_countries")
    private String productionCountries;

    @Column(name = "production_companies")
    private String productionCompanies;

    @Column(name = "vote_count")
    private Long voteCount;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private Trailer trailer;

    private String language;
}
