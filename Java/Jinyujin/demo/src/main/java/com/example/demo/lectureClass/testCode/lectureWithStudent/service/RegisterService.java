package com.example.demo.lectureClass.testCode.lectureWithStudent.service;

import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.LectureRegisterRequestForm;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeRegister;

public interface RegisterService {
    PracticeRegister register(LectureRegisterRequestForm requestForm);
}
