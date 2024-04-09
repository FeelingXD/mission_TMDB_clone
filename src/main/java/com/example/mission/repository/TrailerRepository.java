package com.example.mission.repository;

import com.example.mission.model.entity.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrailerRepository extends JpaRepository<Trailer,Long>,TrailerRepositoryCustom {

    @Query(value =
            """
                select distinct t.trailer_title,t.trailer_overview,t.trailer_url
                        from movie m
                        join platform_type p
                        on m.id=p.movie_id
                        join trailer t
                        on t.movie_id=m.id
                        order by m.release_date desc,m.vote_count desc
                        limit 4
            """
            ,nativeQuery = true)
    List<Object[]> getLatestTrailersByPopular();
    @Query(value=
            """
              select distinct t.trailer_title,t.trailer_overview,t.trailer_url
                        from movie m
                        join platform_type p
                        on m.id=p.movie_id
                        join trailer t
                        on t.movie_id=m.id
                        where p.platform=:platform
                        order by m.release_date desc
                        limit 4
            """
            ,nativeQuery = true)
    List<Object[]> getLatestTrailersByType(String platform);
}
