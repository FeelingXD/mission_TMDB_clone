package com.example.mission.repository;

import com.example.mission.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {

    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.trailer")
    Optional<Movie> getMovieById(long id);

}
