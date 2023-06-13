package com.example.demo.secondExam.test10.service;

import com.example.demo.secondExam.test10.controller.form.Test10AccountRequestForm;
import com.example.demo.secondExam.test10.controller.form.Test17AccountLoginResponseForm;
import com.example.demo.secondExam.test10.entity.Test10Account;

public interface Test10AccountService {
    Test10Account register(Test10AccountRequestForm requestForm);

    Test17AccountLoginResponseForm login(Test10AccountRequestForm requestForm);
}
