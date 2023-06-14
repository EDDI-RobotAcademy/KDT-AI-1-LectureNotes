package com.example.demo.Problem10SignIn.controller.form;

import com.example.demo.Problem10SignIn.entity.BusinessNumber;
import com.example.demo.Problem10SignIn.entity.CategoryType;
import com.example.demo.Problem10SignIn.service.request.AccountRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequestForm {
    final private String email;
    final private String password;
    final private CategoryType categoryType;
    final private int businessNumber;



    public AccountRequest toAccountRequest() {

        return new AccountRequest(email, password, categoryType, businessNumber);
    }
}
