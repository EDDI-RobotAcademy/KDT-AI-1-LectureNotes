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
        // 똑같은 과목인지 아닌지 먼저 강좌명 판별
        if (checkDuplicateLecture(subject)) {
            log.info("강좌명이 중복되었습니다");
            return null;
        }

        // 중복 아닌 과목 등록
        final TestLecture lecture = new TestLecture(subject);
        lectureRepository.save(lecture);

        // 학생 아이디 존재하는지 판별
        final Optional<TestStudent> maybeStudent = studentRepository.findById(studentId);

        if (maybeStudent.isEmpty()) {
            log.info("존재하지 않는 학생입니다");
            return null;
        }

        // 존재하는 학생 찾기
        final TestStudent student = maybeStudent.get();
        // 그 학생한테 변경된 과목 입력
        student.setLecture(lecture);

        // 이제 학생 repository에 저장
        studentRepository.save(student);

        return lecture;
    }

    private Boolean checkDuplicateLecture(String subject) {
        final Optional<TestLecture> maybeLecture = lectureRepository.findByLectureName(subject);

        if (maybeLecture.isEmpty()) {
            return false;
            // 중복 없음
        }
        return true;
    }
}
