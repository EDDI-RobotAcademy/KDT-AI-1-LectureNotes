package com.example.demo.Problem10SignIn.service.request;

import com.example.demo.Problem10SignIn.entity.Account;
import com.example.demo.Problem10SignIn.entity.AccountCategory;
import com.example.demo.Problem10SignIn.entity.BusinessNumber;
import com.example.demo.Problem10SignIn.entity.CategoryType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequest {
    final private String email;
    final private String password;
    final private CategoryType categoryType;
    final private int businessNumber;

    public Account toAccount() {
        return new Account(email, password);
    }
}
