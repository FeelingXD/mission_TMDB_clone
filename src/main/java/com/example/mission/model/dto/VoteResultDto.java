package com.example.mission.model.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteResultDto {
    private Long movieId;
    private Integer voteScore;
}
