package com.example.mission.repository;

import com.example.mission.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> getMovieById(long id);
}
