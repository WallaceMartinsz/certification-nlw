package com.wallace.certification_nlw.domain.student;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CertificationStudent {

    private UUID id;
    private UUID studentID;
    private String technology;
    private int grate;
    private List<AnswersCertifications> answersCertifications;

}
