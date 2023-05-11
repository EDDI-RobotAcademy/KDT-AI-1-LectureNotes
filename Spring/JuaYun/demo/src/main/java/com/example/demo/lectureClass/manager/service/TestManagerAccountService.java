package com.example.demo.lectureClass.manager.service;

import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountLoginResponseForm;
import com.example.demo.lectureClass.manager.controller.form.TestManagerAccountRequestForm;
import com.example.demo.lectureClass.manager.entity.TestManager;

public interface TestManagerAccountService {
    TestManager register(TestManagerAccountRequestForm accountRequestForm);

    TestManagerAccountLoginResponseForm login(TestManagerAccountRequestForm accountRequestForm);
}
