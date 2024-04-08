package com.example.mission.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Trailer {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String trailerTitle;
    private String trailerUrl;
    private String trailerOverview;
}
