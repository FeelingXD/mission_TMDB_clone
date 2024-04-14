package com.example.mission.model.dto.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteForm {
    @Min(value = 1,message = "1 보다 작을 수 없습니다.")
    @Max(value = 10,message = "10 보다 클 수 없습니다.")
    private Integer voteScore;
}
