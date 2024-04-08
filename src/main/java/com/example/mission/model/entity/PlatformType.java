package com.example.mission.model.entity;

import com.example.mission.model.type.Platform;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PlatformType {

    @Id
    private Long id;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.STRING)
    private Platform platform;
}
