package com.example.demo.lectureTest;

import com.example.demo.lectureClass.testCode.lecture.entity.TestLecture;
import com.example.demo.lectureClass.testCode.lecture.service.TestLectureService;
import com.example.demo.lectureClass.testCode.student.entity.TestStudent;
import com.example.demo.lectureClass.testCode.student.service.TestStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LectureTest {
    // 강의를 어떻게 신청하게 만들꺼냐에 대한 윤곽을 잡아줘야 함
    @Autowired
    private TestLectureService testLectureService;

    @Autowired
    private TestStudentService testStudentService;

    @Test
    @DisplayName("x 학생이 Math 수강 신청하기")
    void studentRegisterLecture () {
        final String expected = "Math";

        TestStudent testStudent = new TestStudent("x");
        // 원래라면 RequestForm 형태여야함
        // 지금은 그냥 x라는 학생인 것 나타냄
        testStudent = testStudentService.register(testStudent); // 학생이 사이트에 가입을 해야하기 때문 (현재는 정보 없음)
//        TestStudent registeredStudent = testStudentService.register(testStudent);
        // 헷갈려서 다른 이름으로 바꿨더니 한번 더 타입을 선언해줘야 했음
        // x라는 학생이 있는지 중복검사

        if (testStudent == null) {
            // TestStudentServiceImpl에서 null은 중복일 때 return하도록 했음
            System.out.println("닉네임이 같아 생성하지 않습니다!");
            return;
        }
        // null일 경우 중복인 것 그럼 등록할 필요가 없음
        // 그러니까 return을 하면 아래 코드가 동작하지 않도록
        // if 문에서 이렇게 return을 하면 작동 중인 메서드 중단

        final TestLecture testLecture = testLectureService.register(expected, testStudent.getId());
        final String actual = testLecture.getLectureName();

        assertEquals(expected, actual);
        // 기대한 과목과 실제 선택한 과목이 같냐
    }
}
// 이렇게 실패할 테스트 작성한 것 자체가 백로그
// 이렇게 테스트로 윤곽 잡은 후 차례차례 만들어줘야 함
// 지금은 디비에 진짜 저장하지만 실제로는 모킹해서 테스트 만든다고 함
// (실제 디비에 하면 불상사 생길 수도 있으니께)
