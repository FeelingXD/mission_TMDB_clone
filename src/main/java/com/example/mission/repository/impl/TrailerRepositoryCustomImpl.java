package com.example.mission.repository.impl;

import com.example.mission.model.dto.LatestTrailersDto;
import com.example.mission.model.dto.MovieCardDto;
import com.example.mission.model.dto.TrailerDto;
import com.example.mission.model.entity.PlatformType;
import com.example.mission.model.entity.QMovie;
import com.example.mission.model.entity.QPlatformType;
import com.example.mission.model.entity.QTrailer;
import com.example.mission.model.type.Platform;
import com.example.mission.repository.TrailerRepository;
import com.example.mission.repository.TrailerRepositoryCustom;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TrailerRepositoryCustomImpl implements TrailerRepositoryCustom {
    private final JPAQueryFactory factory;

    QMovie qMovie=QMovie.movie;
    QTrailer qTrailer=QTrailer.trailer;
    QPlatformType qPlatformType = QPlatformType.platformType;

    @Override
    public List<TrailerDto> getLatestTrailersByPopular() {

        var query = factory
                .selectDistinct(qPlatformType.movie.trailer)
                .from(qPlatformType)
                .leftJoin(qPlatformType.movie,qMovie).fetchJoin()
                .leftJoin(qMovie.trailer,qTrailer).fetchJoin()
                .orderBy(qMovie.releaseDate.desc(),qMovie.voteCount.desc())
                .limit(4);



        return query.fetch()
                .stream()
                .map(TrailerDto::fromEntity)
                .toList();
    }

    @Override
    public List<TrailerDto> getLatestTrailersByType(String platform) {
        var query = factory
                .selectDistinct(qPlatformType.movie.trailer)
                .from(qPlatformType)
                .leftJoin(qPlatformType.movie,qMovie).fetchJoin()
                .leftJoin(qMovie.trailer,qTrailer).fetchJoin()
                .orderBy(qMovie.releaseDate.desc(),qMovie.voteCount.desc())
                .limit(4);

        return query.fetch()
                .stream()
                .map(TrailerDto::fromEntity)
                .toList();
    }
}
