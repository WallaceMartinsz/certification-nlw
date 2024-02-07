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
public class Student {

    private UUID id;
    private String email;
    private List<CertificationStudent> certificationStudent;

}
