package com.example.mission.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Trend {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    private LocalDate createdDate;
}
