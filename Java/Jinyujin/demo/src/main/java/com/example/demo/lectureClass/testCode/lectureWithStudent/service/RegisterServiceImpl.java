package com.example.demo.lectureClass.testCode.lectureWithStudent.service;

import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.LectureRegisterRequestForm;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.LectureType;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeLecture;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeRegister;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeStudent;
import com.example.demo.lectureClass.testCode.lectureWithStudent.repository.LecturePracticeRepository;
import com.example.demo.lectureClass.testCode.lectureWithStudent.repository.RegisterRepository;
import com.example.demo.lectureClass.testCode.lectureWithStudent.repository.StudentPracticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService{

    final private RegisterRepository registerRepository;
    final private StudentPracticeRepository studentRepository;
    final private LecturePracticeRepository lectureRepository;

    @Override
    public PracticeRegister register(LectureRegisterRequestForm requestForm) {

        // 1. 학생 등록
        Optional<PracticeStudent> maybeStudent =
                studentRepository.findByName(requestForm.getStudentName());

        if (maybeStudent.isPresent()) {
            return null;
        }

        final PracticeStudent student = requestForm.toStudent();
                studentRepository.save(student);
        // 학생을 어떻게 등록해야 할깡..
        // requestForm.toStudent() 이거!
        // 내가 원하는 엔티티 형식으로 반환받기 위해
        // Form에서 to~ 메서드를 만들어주면 되는게 이런 것이었음!

        // 2. 그 학생이 신청한 과목 등록
        final PracticeLecture lecture = lectureRepository.findByLectureType(
                requestForm.getLectureType());

        final PracticeRegister register =
                new PracticeRegister(student, lecture);

        registerRepository.save(register);

        return register;
    }
}
