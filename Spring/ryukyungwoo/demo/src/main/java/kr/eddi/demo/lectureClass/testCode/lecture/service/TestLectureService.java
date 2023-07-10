package kr.eddi.demo.lectureClass.testCode.lecture.service;

import kr.eddi.demo.lectureClass.testCode.lecture.entity.TestLecture;

public interface TestLectureService {
    TestLecture register (String subject, Long studentId);
}
