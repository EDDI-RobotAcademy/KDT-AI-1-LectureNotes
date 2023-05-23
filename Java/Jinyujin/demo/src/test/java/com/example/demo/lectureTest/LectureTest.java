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
    @Autowired
    private TestStudentService studentService;

    @Autowired
    private TestLectureService lectureService;

    @Test
    @DisplayName("x라는 학생이 Math를 수강신청하기")
    void studentRegisterLecture() {
        final String studentName = "z";
        final String lectureName = "sexy";

//        LectureRequestForm requestForm = new LectureRequestForm(studentName, lectureName);

        TestStudent student = new TestStudent(studentName);
        student = studentService.register(student);
        // 등록할 게 뭔지(student) 입력해줘야지!

        // 학생 중복확인
        if (student == null) {
            System.out.println("동일한 닉네임이 있어 생성하지 않습니다!");
            return;
        }

        // 과목 가져오기
        final TestLecture lecture = lectureService.register(lectureName, student.getId());
        // 등록한 학생의 수강 과목 등록(기대값을 등록)
        // 여기에는 어떤 학생이 등록한건지 알기 위해 student의 Id를 같이 입력해줘야 함(누가 등록한건지 모르자나)

        final String actual = lecture.getLectureName();

        assertEquals(lectureName, actual);
    }
}