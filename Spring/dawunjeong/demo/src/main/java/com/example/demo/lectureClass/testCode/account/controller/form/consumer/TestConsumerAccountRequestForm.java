package com.example.demo.lectureClass.testCode.account.controller.form.consumer;

import com.example.demo.lectureClass.testCode.account.entity.consumer.TestConsumerAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestConsumerAccountRequestForm {

    final private String email;
    final private String password;

    public TestConsumerAccount toTestAccount() {
        return new TestConsumerAccount(email, password);
    }
}
