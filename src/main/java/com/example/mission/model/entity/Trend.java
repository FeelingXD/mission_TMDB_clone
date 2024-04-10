package com.example.mission.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
public class Trend {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    private LocalDate createdDate;
}
