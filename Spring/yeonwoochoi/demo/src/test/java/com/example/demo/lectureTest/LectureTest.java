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

// test 작업 하는 이유 :
// test 가 존재하므로써 front 와 back 이 완벽한 분업이 된다.
// test 는 완성되기 이전에 작업하는 것이다.
// 새롭게 시작하는 서비스 분야에서 Domain 을 분리하는데 도움이 된다.
// 전체 윤곽을 보고 만들어보니 이게 필요하고 이게 필요한게 보이니까 만들면서 찾는다.
// test 작업을 하더라도 고려하지 못한 부분이 있을 수 있다. (예외처리 상황)

// Spring Boot Test에 필요한 의존성을 제공
@SpringBootTest
public class LectureTest {

    // 의존관계 주입(DI)을 할 때 사용하는 어노테이션(Annotation)
    // 의존 객체의 타입에 해당하는 빈(Bean)을 찾아 주입하는 역할
    // 빈이란? 스프링에서는 스프링이 제어권을 가져서 직접 생성하고
    // 의존관계를 부여하는 오브젝트를 빈이라고 부른다.
    @Autowired
    private TestLectureService testLectureService;

    // Spring Framework가 Class를 보고 Type에 맞게(Type을 먼저 확인 후,
    // 없으면 Name 확인) Bean을 주입
    @Autowired
    private TestStudentService testStudentService;

    // @Test JUnit에서 테스트 할 대상을 표시
    @Test
    @DisplayName("x 학생이 Math 수강 신청하기")
    void studentRegisterLecture () {
        final String expected = "Math";
        TestStudent testStudent = new TestStudent("x"); // 원래라면 RequestForm 형태여야함
        testStudent = testStudentService.register(testStudent);  // 학생이 사이트에 가입을 해야하기 때문 (현재는 정보 없음)

        if (testStudent == null) {
            System.out.println("닉네임이 같아 생성하지 않습니다!");
            return;
        }

        final TestLecture testLecture = testLectureService.register(expected, testStudent.getId());
        final String actual = testLecture.getLectureName();

        // assertEquals :
        // 객체 x와 y가 일치함을 확인합니다.
        // x(예상 값)와 y(실제 값)가 같으면 테스트 통과
        assertEquals(expected, actual);
    }

}