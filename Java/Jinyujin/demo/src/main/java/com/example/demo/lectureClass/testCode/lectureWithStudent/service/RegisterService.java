package com.example.demo.lectureClass.testCode.lectureWithStudent.service;

import com.example.demo.lectureClass.testCode.lectureWithStudent.controller.form.RegisterRequestForm;
import com.example.demo.lectureClass.testCode.lectureWithStudent.entity.PracticeRegister;

public interface RegisterService {
    PracticeRegister register(RegisterRequestForm requestForm);
}
