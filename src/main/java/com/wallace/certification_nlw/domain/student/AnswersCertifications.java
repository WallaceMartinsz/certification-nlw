package com.wallace.certification_nlw.domain.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Answers_certifications_students")
@Builder
public class AnswersCertifications {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "certification_id")
    private UUID certificaitonID;

    @ManyToOne
    @JoinColumn(name = "certification_id", insertable = false, updatable = false)
    @JsonBackReference
    private CertificationStudent certificationStudent;

    @Column(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "question_id")
    private UUID questionID;

    @Column(name = "answer_id")
    private UUID answerID;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
