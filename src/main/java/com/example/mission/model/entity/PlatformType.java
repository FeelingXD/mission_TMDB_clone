package com.example.mission.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


@Entity
@Getter
@IdClass(PlatformType.PlatformPK.class)
public class PlatformType {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Id
    @Column(name = "platform")
    private String platform;

    @Data
    @Embeddable
    public class PlatformPK implements Serializable {
        private Movie movie;
        private String platform;
    }
}
