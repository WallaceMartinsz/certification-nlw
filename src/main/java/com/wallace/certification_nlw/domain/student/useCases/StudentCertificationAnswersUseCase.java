package com.wallace.certification_nlw.domain.student.useCases;

import com.wallace.certification_nlw.domain.questions.Question;
import com.wallace.certification_nlw.domain.student.AnswersCertifications;
import com.wallace.certification_nlw.domain.student.CertificationStudent;
import com.wallace.certification_nlw.domain.student.Student;
import com.wallace.certification_nlw.domain.student.dto.StudentCertificationAnswersDTO;
import com.wallace.certification_nlw.domain.student.dto.VerifyHasCertificationDTO;
import com.wallace.certification_nlw.repositories.CertificationStudentRepository;
import com.wallace.certification_nlw.repositories.QuestionRepository;
import com.wallace.certification_nlw.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersUseCase {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    public CertificationStudent execute(StudentCertificationAnswersDTO dto) throws Exception {

        var hasCertification = this.verifyIfHasCertificationUseCase.execute(new VerifyHasCertificationDTO(dto.getEmail(), dto.getTechnology()));

        if(hasCertification){
            throw new Exception("Você já tirou sua certificação!");
        }

        List<Question> questions = questionRepository.findByTechnology(dto.getTechnology());

        List<AnswersCertifications> answersCertifications = new ArrayList<>();

        AtomicInteger correctAnswers = new AtomicInteger(0);

        dto.getQuestionsAnswers().stream().forEach(questionAnswer -> {
            var question = questions.stream().filter(q -> q.getId().equals(questionAnswer.getQuestionID())).findFirst().get();

            var findCorrectAlternative = question.getAlternatives().stream().filter(alternative -> alternative.isCorrect()).findFirst().get();

            if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())){
                questionAnswer.setCorrect(true);
                correctAnswers.incrementAndGet();
            }else {
                questionAnswer.setCorrect(false);
            }

            var answerCertification = AnswersCertifications.builder().answerID(questionAnswer
                            .getAlternativeID())
                            .questionID(questionAnswer.getQuestionID())
                            .isCorrect(questionAnswer.isCorrect()).build();

            answersCertifications.add(answerCertification);
        });

        var student = studentRepository.findByEmail(dto.getEmail());
        UUID studentID;
        if(student.isEmpty()){
            var studentCreated = Student.builder().email(dto.getEmail()).build();
            studentCreated = studentRepository.save(studentCreated);
            studentID = studentCreated.getId();
        }else {
            studentID = student.get().getId();
        }

        CertificationStudent certificationStudent = CertificationStudent.builder()
                .technology(dto.getTechnology())
                .studentID(studentID)
                .grade(correctAnswers.get())
                .build();

        var certificationStudentCreated = certificationStudentRepository.save(certificationStudent);

        answersCertifications.stream().forEach(answersCertifications1 -> {
            answersCertifications1.setCertificaitonID(certificationStudent.getId());
            answersCertifications1.setCertificationStudent(certificationStudent);
        });

        certificationStudent.setAnswersCertifications(answersCertifications);

        certificationStudentRepository.save(certificationStudent);

        return certificationStudentCreated;
    }

}
