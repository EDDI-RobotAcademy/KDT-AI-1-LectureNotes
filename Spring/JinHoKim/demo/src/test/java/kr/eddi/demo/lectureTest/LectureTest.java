package kr.eddi.demo.lectureTest;

import kr.eddi.demo.lectureClass.testCode.lecture.entity.TestLecture;
import kr.eddi.demo.lectureClass.testCode.lecture.service.TestLectureService;
import kr.eddi.demo.lectureClass.testCode.student.entity.TestStudent;
import kr.eddi.demo.lectureClass.testCode.student.service.TestStudentService;
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
    void studentRegisterLecture () {
        final String expected = "영어";
        TestStudent testStudent = new TestStudent("y"); // 원래라면 RequestForm 형태여야함
        testStudent = testStudentService.register(testStudent);  // 학생이 사이트에 가입을 해야하기 때문 (현재는 정보 없음)

        if (testStudent == null) {
            System.out.println("닉네임이 같아 생성하지 않습니다!");
        }

        final TestLecture testLecture = testLectureService.register(expected, testStudent.getId());
        final String actual = testLecture.getLectureName();

        assertEquals(expected, actual);
    }
}
