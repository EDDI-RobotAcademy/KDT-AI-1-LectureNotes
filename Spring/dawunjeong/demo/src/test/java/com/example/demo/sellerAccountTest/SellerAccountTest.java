package com.example.demo.sellerAccountTest;

import com.example.demo.lectureClass.testCode.account.controller.form.seller.TestSellerAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.seller.TestSellerAccount;
import com.example.demo.lectureClass.testCode.account.service.seller.TestSellerAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SellerAccountTest {
    @Autowired
    private TestSellerAccountService testSellerAccountService;

    @Test
    @DisplayName("판매자 계정 등록하기")
    void 판매자_계정_등록하기 () {
        final String email = "seller2@test.com";
        final String password = "seller2";

        TestSellerAccountRequestForm requestForm = new TestSellerAccountRequestForm(email, password);
        TestSellerAccount sellerAccount = testSellerAccountService.register(requestForm);

        assertEquals(email, sellerAccount.getEmail());
        assertEquals(password, sellerAccount.getPassword());
    }
}
