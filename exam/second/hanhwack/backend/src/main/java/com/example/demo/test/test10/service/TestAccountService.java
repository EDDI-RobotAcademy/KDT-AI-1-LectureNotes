package com.example.demo.test.test10.service;

import com.example.demo.test.test10.controller.form.TestAccountRequestForm;
import com.example.demo.test.test10.controller.form.TestAccountWithBusinessNumberForm;
import com.example.demo.test.test10.entity.TestAccount;

public interface TestAccountService {
    TestAccount register(TestAccountRequestForm requestForm);
    TestAccount registerWithBusinessNumber(TestAccountWithBusinessNumberForm requestForm);

}