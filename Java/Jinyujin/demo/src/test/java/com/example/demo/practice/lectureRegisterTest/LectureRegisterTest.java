package com.example.demo.practice.lectureRegisterTest;

import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.LectureRegisterRequestForm;
import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.StudentRequestForm;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.LectureType;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeRegister;
import com.example.demo.lectureClass.testCode.lectureWithStudent.service.RegisterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.lectureClass.testCode.lectureWithStudent.entity.LectureType.*;

@SpringBootTest
public class LectureRegisterTest {

    @Autowired
    private RegisterService registerService;

    @Test
    @DisplayName("수강신청 리팩토링")
    void lectureRegisterWithStudent() {

        final String studentName = "뿅뿅이";
        // student는 정해져 있지 않고 계속 생성되니까 String이 맞는 것 같애
//        final String lectureName = "상큼이";
        // 근데 과목은 enum으로 하는게 맞는 것 같애
         final LectureType lectureType = MATH;

//        PracticeStudent student = new PracticeStudent(studentName);
        // student에 대한 정보는 받아와야 하니까
        // request폼을 따로 만들어줄 필요가 있어보임
        StudentRequestForm studentRequestForm = new StudentRequestForm(studentName);
//        PracticeLecture lecture = new PracticeLecture(lectureName, student);

        LectureRegisterRequestForm registerRequestForm =
                new LectureRegisterRequestForm(studentRequestForm.getStudentName(), lectureType);
        // getStudentName()으로 받아오는게 맞나?

        PracticeRegister practiceRegister = registerService.register(registerRequestForm);
        // Test는 잘 되지만 lecture_type 테이블이 따로 생성되지 않고 Lecture테이블에 생성되는 문제가 있음
        // 몰 잘못했을까?
        // @Table(name)! 이것이 바로 테이블의 이름을 설정해주는 것이었음을
    }
}
