package com.example.demo.lectureClass.testCode.student.service;

import com.example.demo.lectureClass.testCode.student.entity.TestStudent;
import com.example.demo.lectureClass.testCode.student.repository.TestStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestStudentServiceImpl implements TestStudentService{

    final private TestStudentRepository studentRepository;

    @Override
    public TestStudent register(TestStudent student) {
        final Optional<TestStudent> maybeStudent = studentRepository.findByName(student.getName());

        if (maybeStudent.isPresent()) {
            log.info("존재하는 학생입니다!");
            return null;
        }
        return studentRepository.save(student);
    }
}
