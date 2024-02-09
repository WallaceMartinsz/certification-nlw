package com.wallace.certification_nlw.domain.student.useCases;

import com.wallace.certification_nlw.domain.student.dto.VerifyHasCertificationDTO;
import com.wallace.certification_nlw.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyHasCertificationDTO dto){
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.email(), dto.technology());
        return !result.isEmpty();
    }
}
