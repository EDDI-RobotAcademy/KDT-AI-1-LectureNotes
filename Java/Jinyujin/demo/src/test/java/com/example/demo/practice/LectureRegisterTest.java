package com.example.demo.practice;

import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.RegisterRequestForm;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeLecture;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeRegister;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeStudent;
import com.example.demo.lectureClass.testCode.lectureWithStudent.service.RegisterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LectureRegisterTest {

    @Autowired
    private RegisterService registerService;

    @Test
    @DisplayName("수강신청 리팩토링")
    void lectureRegistWithStudent() {

        final String studentName = "상큼이";
        // student는 정해져 있지 않고 계속 생성되니까 String이 맞는 것 같애
        final String lectureName = "상큼이";
        // 근데 과목은 enum으로 하는게 맞는 것 같애

        PracticeStudent student = new PracticeStudent(studentName);
        PracticeLecture lecture = new PracticeLecture(lectureName, student);

        RegisterRequestForm requestForm = new RegisterRequestForm(student, lecture);

        PracticeRegister practiceRegister = registerService.register(requestForm);
    }
}
