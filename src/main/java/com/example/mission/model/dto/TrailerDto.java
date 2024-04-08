package com.example.mission.model.dto;

import com.example.mission.model.entity.Trailer;
import lombok.*;

import java.util.Objects;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrailerDto {

    private String trailerTitle = null;
    private String trailerUrl = null;
    private String trailerOverview = null;

    public static TrailerDto fromEntity(Trailer trailer){
        return Objects.isNull(trailer) ? new TrailerDto() :
                TrailerDto.builder()
                .trailerTitle(trailer.getTrailerTitle())
                .trailerUrl(trailer.getTrailerUrl())
                .trailerOverview(trailer.getTrailerOverview())
                .build();
    }
}
