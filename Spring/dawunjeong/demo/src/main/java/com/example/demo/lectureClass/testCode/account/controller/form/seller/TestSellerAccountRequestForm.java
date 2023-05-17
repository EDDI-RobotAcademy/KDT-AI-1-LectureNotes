package com.example.demo.lectureClass.testCode.account.controller.form.seller;

import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestSellerAccountRequestForm {
    final private String email;
    final private String password;

    public TestSellerAccount toTestSellerAccount() {
        return new TestSellerAccount(email, password);
    }
}
