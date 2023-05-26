package com.example.demo.problem10.controller.form;


import com.example.demo.problem10.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRequestForm {
    private String email;
    private String password;
    private Long companyNumber;

    public Account toAccount(){
        return new Account(email, password, companyNumber);
    }

    public AccountRequestForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountRequestForm(String email, String password, Long companyNumber) {
        this.email = email;
        this.password = password;
        this.companyNumber = companyNumber;
    }
}