package com.example.demo.lectureClass.testCode.account.service.consumer;

import com.example.demo.lectureClass.testCode.account.controller.form.consumer.TestConsumerAccountLoginResponseForm;
import com.example.demo.lectureClass.testCode.account.controller.form.consumer.TestConsumerAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.consumer.TestConsumerAccount;

public interface TestConsumerAccountService {

    TestConsumerAccount register(TestConsumerAccountRequestForm requestForm);

    TestConsumerAccountLoginResponseForm login(TestConsumerAccountRequestForm requestForm);

}
