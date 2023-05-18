package com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form;

import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.LectureType;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeStudent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LectureRegisterRequestForm {

    final private String studentName;
    final private LectureType lectureType;
    public PracticeStudent toStudent() {
        return new PracticeStudent(studentName);
    }

//    final private PracticeStudent student;
//    final private PracticeLecture lecture;
//
//
//    public PracticeRegister toRegister() {
//        return new PracticeRegister(student, lecture);
//        // 이걸 굳이 해줄 필요는 없는 것 같은데..
          // 웅 안해줘두 됨
//    }
}
