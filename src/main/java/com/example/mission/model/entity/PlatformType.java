package com.example.mission.model.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@IdClass(PlatformPK.class)
public class PlatformType {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Id
    @Column(name = "platform")
    private String platform;


}
