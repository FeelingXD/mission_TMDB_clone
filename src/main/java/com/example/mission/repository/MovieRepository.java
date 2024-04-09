package com.example.mission.repository;

import com.example.mission.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> , MovieRepositoryCustom {

    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.trailer")
    Optional<Movie> getMovieById(long id);

    @Query(value = """
            select distinct m.id,m.title,m.release_date,m.poster_path,m.vote_average
                        from movie m
                        join platform_type p
                        on m.id=p.movie_id
                        where p.platform=:platform
                        order by m.vote_count desc
                        limit 20
            """,nativeQuery = true)
    List<Object[]> getPopularMoviesByPlatform(String platform);
}
