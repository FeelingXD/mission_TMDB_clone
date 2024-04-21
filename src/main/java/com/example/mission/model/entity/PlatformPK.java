package com.example.mission.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class PlatformPK implements Serializable {
    private Movie movie;
    private String platform;
}
