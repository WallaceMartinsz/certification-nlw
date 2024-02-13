package com.wallace.certification_nlw.controllers;

import com.wallace.certification_nlw.domain.certifications.useCases.Top10RankingUseCase;
import com.wallace.certification_nlw.domain.student.CertificationStudent;
import com.wallace.certification_nlw.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private Top10RankingUseCase top10RankingUseCase;

    @GetMapping("/top10")
    public List<CertificationStudent> top10() {
        return this.top10RankingUseCase.execute();
    }
}
