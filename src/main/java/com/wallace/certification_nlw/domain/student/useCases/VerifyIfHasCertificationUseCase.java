package com.wallace.certification_nlw.domain.student.useCases;

import com.wallace.certification_nlw.domain.student.dto.VerifyHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    public boolean execute(VerifyHasCertificationDTO dto){
        if (dto.email().equals("wallace@gmail.com") && dto.technology().equals("Java")){
            return true;
        }
        return false;
    }
}
