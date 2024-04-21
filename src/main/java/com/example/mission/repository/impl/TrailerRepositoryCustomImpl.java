package com.example.mission.repository.impl;

import com.example.mission.model.dto.TrailerDto;
import com.example.mission.model.entity.QMovie;
import com.example.mission.model.entity.QPlatformType;
import com.example.mission.model.entity.QTrailer;
import com.example.mission.repository.TrailerRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TrailerRepositoryCustomImpl implements TrailerRepositoryCustom {
    private final JPAQueryFactory factory;

    private final QMovie qMovie = QMovie.movie;
    private final QTrailer qTrailer = QTrailer.trailer;
    private final QPlatformType qPlatformType = QPlatformType.platformType;

    @Override
    public List<TrailerDto> getLatestTrailersByPopular() {

        var query = factory
                .select(qPlatformType, qMovie, qTrailer)
                .distinct()
                .from(qPlatformType)
                .leftJoin(qPlatformType.movie, qMovie).fetchJoin()
                .leftJoin(qMovie.trailer, qTrailer).fetchJoin()
                .groupBy(qTrailer)
                .orderBy(qMovie.releaseDate.desc(), qMovie.voteCount.desc())
                .limit(4);


        return query.fetch()
                .stream()
                .map(tuple -> tuple.get(qTrailer))
                .map(TrailerDto::fromEntity)
                .toList();
    }

    @Override
    public List<TrailerDto> getLatestTrailersByType(String platform) {
        var query = factory
                .select(qPlatformType, qMovie, qTrailer)
                .from(qPlatformType)
                .leftJoin(qPlatformType.movie, qMovie).fetchJoin()
                .leftJoin(qMovie.trailer, qTrailer).fetchJoin()
                .where(qPlatformType.platform.eq(platform))
                .groupBy(qTrailer)
                .orderBy(qMovie.releaseDate.desc(), qMovie.voteCount.desc())
                .limit(4);

        return query.fetch()
                .stream()
                .map(tuple -> tuple.get(qTrailer))
                .map(TrailerDto::fromEntity)
                .toList();
    }
}
