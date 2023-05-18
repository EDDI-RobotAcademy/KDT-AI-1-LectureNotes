package com.example.demo.lectureClass.testCode.account.service.seller;

import com.example.demo.lectureClass.testCode.account.controller.form.seller.TestSellerAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;

public interface TestSellerAccountService {
    TestSellerAccount register(TestSellerAccountRequestForm requestForm);

    TestSellerAccount findSellerAccount(TestSellerAccountRequestForm requestForm);
}
