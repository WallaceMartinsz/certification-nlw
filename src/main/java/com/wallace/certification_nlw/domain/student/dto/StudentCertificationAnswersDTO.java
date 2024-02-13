package com.wallace.certification_nlw.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCertificationAnswersDTO {

    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionsAnswers;

}
