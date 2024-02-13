package com.wallace.certification_nlw.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {

    private UUID questionID;
    private UUID alternativeID;
    private boolean isCorrect;
}
