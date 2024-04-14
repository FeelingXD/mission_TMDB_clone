package com.example.mission.model.dto.form;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteForm {
    private Integer voteScore;
}
