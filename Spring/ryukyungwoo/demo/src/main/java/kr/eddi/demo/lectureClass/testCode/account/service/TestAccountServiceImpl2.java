package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm2;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount2;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl2 implements TestAccountService2{

    @Autowired
    final private TestAccountRepository2 testAccountRepository2;

    @Override
    public TestAccount2 register(TestAccountRequestForm2 testAccountRequestForm2) {
//        return testAccountRepository2.save();
        return null;
    }
}
