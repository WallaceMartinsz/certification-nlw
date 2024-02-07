package com.wallace.certification_nlw.domain.student;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnswersCertifications {

    private UUID id;
    private UUID certificaitonID;
    private UUID studentID;
    private UUID questionID;
    private UUID answerID;
    private boolean isCorrect;
}
