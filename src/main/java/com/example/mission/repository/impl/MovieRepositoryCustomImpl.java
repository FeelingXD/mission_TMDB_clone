package com.example.mission.repository.impl;

import com.example.mission.model.dto.MovieRecommendDto;
import com.example.mission.model.entity.QMovie;
import com.example.mission.repository.MovieRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    QMovie qMovie=QMovie.movie;
    @Override
    public List<MovieRecommendDto> getRecommendMoviesById(Long id) { //todo : 영화 추천 같은 장르 영화 에서 voteCount 큰순
        var condition_find_genre_by_movie_id=queryFactory
                .select(qMovie.genre)
                .from(qMovie)
                .where(qMovie.id.eq(id));
        var query = queryFactory.selectFrom(qMovie)
                .leftJoin(qMovie.trailer)
                .fetchJoin()
                .from(qMovie)
                .where(qMovie.genre.eq(condition_find_genre_by_movie_id))
                .orderBy(qMovie.voteCount.desc())
                .limit(10);
        return query.fetch()
                .stream().map(MovieRecommendDto::fromEntity).toList();
    }
}
