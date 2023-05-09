package com.example.demo.lectureClass.testCode.lecture.service;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;
import com.example.demo.lectureClass.testCode.lecture.repository.TestLectureRepository;
import com.example.demo.lectureClass.testCode.student.entity.TestStudent;
import com.example.demo.lectureClass.testCode.student.repository.TestStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestLectureServiceImpl implements TestLectureService{
    final private TestLectureRepository lectureRepository;
    final private TestStudentRepository studentRepository;

    @Override
    public TestLecture register(String subject, Long studentId) {
        if (checkDuplicateOfLecture(subject)) {
            log.info("강좌명이 중복되었습니다!");
            return null;
        }
        // checkDuplicateOfLecture 메서드에서 true가 반환될 경우
        // 이 if문이 수행된다 (false일 경우 수행안하고 아래 코드 수행)

        final TestLecture testLecture = new TestLecture(subject);
        lectureRepository.save(testLecture);

        final Optional<TestStudent> maybeStudent = studentRepository.findById(studentId);
        // findById() 사용하면 Optional 떠올리자

        if (maybeStudent.isEmpty()) {
            log.info("존재하지 않는 학생입니다!");
            return null;
        }

        final TestStudent testStudent = maybeStudent.get();
        testStudent.setTestLecture(testLecture);
        studentRepository.save(testStudent);

        return testLecture;
    }

    private Boolean checkDuplicateOfLecture(String subject) {
        final Optional<TestLecture> maybeLecture = lectureRepository.findByLectureName(subject);

        if (maybeLecture.isEmpty()) {
            log.info("중복 없음");
            return false;
        }

        return true;
    }
}
