package com.example.mission.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PlatformPK implements Serializable {
    private Movie movie;
    private String platform;
}
