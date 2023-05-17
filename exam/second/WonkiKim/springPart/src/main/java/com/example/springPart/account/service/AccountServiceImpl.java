package com.example.springPart.account.service;

import com.example.springPart.account.controller.form.LogInRequestForm;
import com.example.springPart.account.controller.form.SignUpRequestForm;
import com.example.springPart.account.entity.Account;
import com.example.springPart.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    final AccountRepository accountRepository;
    @Override
    public Account signUp(SignUpRequestForm signUpRequestForm) {

        Optional<Account> maybeAccount = accountRepository.findByEmail(signUpRequestForm.getEmail());
        if(maybeAccount.isPresent()){
            return null;
        }
        Account createdAccount = signUpRequestForm.toAccount();
        return accountRepository.save(createdAccount);
    }

    @Override
    public Account logIn(LogInRequestForm requestForm) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(requestForm.getEmail());
        if(maybeAccount.isEmpty()) {
            return null;
        }
        if(maybeAccount.get().getPassword().equals(requestForm.getPassword())) {
            return maybeAccount.get();
        }
        return null;
    }
}
