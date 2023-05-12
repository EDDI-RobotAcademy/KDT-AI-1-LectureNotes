package com.example.demo.lectureClass.lecture.service;

import com.example.demo.lectureClass.lecture.entity.TestLecture;

public interface TestLectureService {
    TestLecture register (String subject, Long studentId);
}
