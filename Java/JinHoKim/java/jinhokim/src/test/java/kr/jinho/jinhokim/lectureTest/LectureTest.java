package kr.jinho.jinhokim.lectureTest;

import kr.jinho.jinhokim.testCode.lecture.entity.TestLecture;
import kr.jinho.jinhokim.testCode.lecture.service.TestLectureService;
import kr.jinho.jinhokim.testCode.student.entity.TestStudent;
import kr.jinho.jinhokim.testCode.student.service.TestStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LectureTest {

    @Autowired
    private TestLectureService testLectureService;

    @Autowired
    private TestStudentService testStudentService;

    @Test
    @DisplayName("x 학생이 Math 수강 신청하기")
    void studentRegisterLecture() {
        final String expected = "Math";
        TestStudent testStudent = new TestStudent("x");
        testStudent = testStudentService.register(testStudent);

        if (testStudent == null) {
            System.out.println("닉네임이 같아 생성하지 않습니다");
            return;
        }

        final TestLecture testLecture = testLectureService.register(expected, testStudent.getId());
        final String actual = testLecture.getLectureName();

        assertEquals(expected, actual);
        }

}
