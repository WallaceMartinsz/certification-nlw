package com.wallace.certification_nlw.repositories;

import com.wallace.certification_nlw.domain.student.CertificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CertificationStudentRepository extends JpaRepository<CertificationStudent, UUID> {

    @Query("SELECT c FROM Certifications c INNER JOIN c.student std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudent> findByStudentEmailAndTechnology(String email, String technology);

    @Query("SELECT c from Certifications c ORDER BY c.grade DESC LIMIT 10")
    List<CertificationStudent> findTop10ByOrderByGradeDesc();
}
