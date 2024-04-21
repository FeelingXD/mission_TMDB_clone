package com.example.mission.repository.impl;

import com.example.mission.model.dto.MovieCardDto;
import com.example.mission.model.dto.MovieRecommendDto;
import com.example.mission.model.entity.QMovie;
import com.example.mission.model.entity.QPlatformType;
import com.example.mission.repository.MovieRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMovie qMovie = QMovie.movie;
    private final QPlatformType qPlatformType = QPlatformType.platformType;

    @Override
    public List<MovieRecommendDto> getRecommendMoviesById(Long id) { //todo : 영화 추천 같은 장르 영화 에서 voteCount 큰순

        var condition_find_genre_by_movie_id = queryFactory
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

    public List<MovieCardDto> getPopularMoviesByPlatform(String platform) {

        var query = queryFactory
                .select(qPlatformType, qMovie)
                .distinct()
                .from(qPlatformType)
                .leftJoin(qPlatformType.movie, qMovie).fetchJoin()
                .leftJoin(qMovie.trailer).fetchJoin()
                .where(qPlatformType.platform.eq(platform))
                .orderBy(qMovie.voteCount.desc())
                .limit(20);

        return query.fetch()
                .stream()
                .map(tuple -> tuple.get(qMovie))
                .filter(Objects::nonNull)
                .map(MovieCardDto::fromEntity)
                .toList();

    }
}
