package com.example.demo.lectureClass.testCode.lecture.service;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;

public interface TestLectureService {
    TestLecture register (String subject, Long studentId);
}
