package com.wallace.certification_nlw.controllers;

import com.wallace.certification_nlw.domain.student.dto.VerifyHasCertificationDTO;
import com.wallace.certification_nlw.domain.student.useCases.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public ResponseEntity<String> verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){

        var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if(result)
            return ResponseEntity.ok("Usuário já fez a prova");
        return ResponseEntity.ok("Usuário pode fazer a prova");
    }
}
