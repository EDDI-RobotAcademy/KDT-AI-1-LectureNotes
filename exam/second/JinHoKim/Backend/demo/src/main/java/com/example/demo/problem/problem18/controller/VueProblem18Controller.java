package com.example.demo.problem.problem18.controller;

import com.example.demo.problem.problem18.entity.Account;
import com.example.demo.problem.problem18.form.AccountForm;
import com.example.demo.problem.problem18.form.LoginResponseForm;
import com.example.demo.problem.problem18.form.RequestAccountIdForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
public class VueProblem18Controller {

    private final List<Account> accountList = new ArrayList<>();
    private static Long accountId = 1L;

    @PostMapping("/create")
    public Boolean createAccount(@RequestBody AccountForm accountForm) {
        log.info("createAccount()");

        final Account account = accountForm.toAccount(accountId++);

        if (checkDuplicatedEmail(account))
            return false;

        accountList.add(account);

        return true;
    }


    @PostMapping("/login")
    public LoginResponseForm accountLogin(@RequestBody AccountForm accountForm) {
        log.info("!!!!");

        final Long LOGIN_FAILED_ACCOUNT_ID = 0L;

        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountEmail = searchedAccount.getEmail();

            if (searchedAccountEmail.equals(accountForm.getEmail())) {
                if (searchedAccount.getPassword().equals(accountForm.getPassword())) {
                    return new LoginResponseForm(true, searchedAccount.getId());
                }
                return new LoginResponseForm((false), LOGIN_FAILED_ACCOUNT_ID);
            }
        }
        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);

    }


    @PostMapping("/find-account-info")
    public String findAccountInfo(@RequestBody RequestAccountIdForm requestAccountIdForm) {
        final int LIST_BIAS = 1;
        final Account foundAccount = accountList.get((int) (requestAccountIdForm.getAccountId() - LIST_BIAS));

        return foundAccount.getEmail();
    }



    private boolean checkDuplicatedEmail(Account account) {
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);
            final String searchedAccountEmail = searchedAccount.getEmail();

            if (account.getEmail().equals(searchedAccountEmail)) {
                return true;
            }
        }
        return false;
    }

}
