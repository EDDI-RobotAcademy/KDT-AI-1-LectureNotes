package com.example.demo.lectureClass.testCode.lecture.service;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;

public interface TestLectureService {

    TestLecture register(String subject, Long studentId);
    // 강의 등록은 과목명과 학생Id 필요
}
