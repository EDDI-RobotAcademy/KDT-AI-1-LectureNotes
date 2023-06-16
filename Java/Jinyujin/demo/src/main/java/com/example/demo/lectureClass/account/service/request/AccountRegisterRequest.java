package com.example.demo.lectureClass.account.service.request;

import com.example.demo.lectureClass.account.entity.MemberAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {
    final private String email;

    public MemberAccount toAccount() {
        return new MemberAccount(email);
    }
}
