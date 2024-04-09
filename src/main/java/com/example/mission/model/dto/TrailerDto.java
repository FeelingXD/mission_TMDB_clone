package com.example.mission.model.dto;

import com.example.mission.model.entity.Trailer;
import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public static TrailerDto objToTrailerDto(Object[] obj) { // todo obj->tailerDto가 되어야함
        return TrailerDto.builder()
                .trailerTitle((String) obj[0])
                .trailerOverview((String) obj[1])
                .trailerUrl((String) obj[2])
                .build();
    }
}
