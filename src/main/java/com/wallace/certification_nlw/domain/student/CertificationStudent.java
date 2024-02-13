package com.wallace.certification_nlw.domain.student;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Certifications")
@Builder
public class CertificationStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "student_id")
    private UUID studentID;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "asnwer_certification_id", insertable = false, updatable = false)
    @JsonManagedReference
    private List<AnswersCertifications> answersCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
