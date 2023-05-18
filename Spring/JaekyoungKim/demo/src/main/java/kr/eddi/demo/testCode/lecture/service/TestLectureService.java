package kr.eddi.demo.testCode.lecture.service;

import kr.eddi.demo.testCode.lecture.entity.TestLecture;

public interface TestLectureService {

    TestLecture register (String subject, Long studentId);
}

