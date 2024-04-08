package com.example.mission.model.entity;

import com.example.mission.model.type.Platform;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


@Entity
@Getter
public class PlatformType {

    @EmbeddedId
    private PlatformPK id;
    @Data
    @Embeddable
    public class PlatformPK implements Serializable{
        @Column(name ="movie_id")
        private Long movieId;
        @Column(name="platform")
        private String platform;
    }
}
