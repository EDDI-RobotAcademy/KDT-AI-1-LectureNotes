package com.example.demo.lectureClass.testCode.lectureWithStudent.service;

import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.RegisterRequestForm;
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
    public PracticeRegister register(RegisterRequestForm requestForm) {

        // 1. 학생 등록
        Optional<PracticeStudent> maybeStudent = studentRepository.findByName(requestForm.getStudent().getName());

        if (maybeStudent.isPresent()) {
            return null;
        }

        studentRepository.save(requestForm.getStudent());

        // 2. 그 학생이 신청한 과목 등록
        // 똑같은 과목인지 아닌지 강좌명 판별
        if (checkDuplicateLecture(requestForm.getLecture().getName())) {
            return null;
        }

        lectureRepository.save(requestForm.getLecture());

        final PracticeRegister practiceRegister = requestForm.toRegister();

        return registerRepository.save(practiceRegister);
    }

    private Boolean checkDuplicateLecture(String subject) {
        final Optional<PracticeLecture> maybeLecture = lectureRepository.findByName(subject);

        if (maybeLecture.isEmpty()) {
            return false;
        }
        return true;
    }
}
