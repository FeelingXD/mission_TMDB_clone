package com.example.mission.repository.impl;

import com.example.mission.model.dto.MovieCardDto;
import com.example.mission.model.entity.QMovie;
import com.example.mission.model.entity.QTrend;
import com.example.mission.repository.TrendRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class TrendRepositoryCustomImpl implements TrendRepositoryCustom {
    private final JPAQueryFactory factory;
    QTrend qTrend = QTrend.trend;
    QMovie qMovie = QMovie.movie;

    @Override
    public List<MovieCardDto> getTodayMovieTrend() {

        var query = factory
                .select(qTrend, qTrend.movie.count())
                .from(qTrend)
                .leftJoin(qTrend.movie, qMovie).fetchJoin()
                .leftJoin(qMovie.trailer).fetchJoin()
                .where(qTrend.createdDate.eq(LocalDate.now().minusDays(1)))
                .groupBy(qTrend.movie.id)
                .orderBy(qTrend.movie.count().desc())
                .fetch();


        return query.stream().map(tuple -> Objects.requireNonNull(tuple.get(qTrend)).getMovie())
                .filter(Objects::nonNull)
                .map(MovieCardDto::fromEntity)
                .toList();

    }

    @Override
    public List<MovieCardDto> getThisWeekMovieTrend() {
        var query = factory
                .select(qTrend, qTrend.movie.count())
                .from(qTrend)
                .leftJoin(qTrend.movie).fetchJoin()
                .leftJoin(qMovie.trailer).fetchJoin()
                .where(qTrend.createdDate.goe(LocalDate.now().minusDays(7)))
                .groupBy(qTrend.movie.id)
                .orderBy(qTrend.movie.count().desc())
                .fetch();


        return query.stream().map(tuple -> Objects.requireNonNull(tuple.get(qTrend)).getMovie())
                .filter(Objects::nonNull)
                .map(MovieCardDto::fromEntity)
                .toList();

    }
}
