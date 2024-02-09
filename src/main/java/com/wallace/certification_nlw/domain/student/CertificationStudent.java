package com.wallace.certification_nlw.domain.student;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Certifications")
public class CertificationStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @JoinColumn(name = "student_id")
    private UUID studentID;
    @Column(length = 100)
    private String technology;
    @Column(length = 10)
    private int grate;
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @OneToMany
    @JoinColumn(name = "asnwer_certification_id", insertable = false, updatable = false)
    private List<AnswersCertifications> answersCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
