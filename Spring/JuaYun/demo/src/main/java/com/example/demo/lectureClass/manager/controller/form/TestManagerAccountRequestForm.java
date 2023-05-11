package com.example.demo.lectureClass.manager.controller.form;

import com.example.demo.lectureClass.manager.entity.TestManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestManagerAccountRequestForm {

    final private String managerEmail;
    final private String managerPassword;

    public TestManager toTestManager() {
        return new TestManager(managerEmail, managerPassword);
    }
}
