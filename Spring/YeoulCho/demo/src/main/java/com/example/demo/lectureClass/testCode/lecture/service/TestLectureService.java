package com.example.demo.lectureClass.testCode.lecture.service;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;
import com.example.demo.lectureClass.testCode.student.entity.TestStudent;

public interface TestLectureService {
    TestLecture register(String subject, Long studentId);

}
