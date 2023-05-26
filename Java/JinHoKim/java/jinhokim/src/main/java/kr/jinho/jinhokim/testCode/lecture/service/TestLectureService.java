package kr.jinho.jinhokim.testCode.lecture.service;

import kr.jinho.jinhokim.testCode.lecture.entity.TestLecture;

public interface TestLectureService {
    TestLecture register(String subject, Long studentId);
}
