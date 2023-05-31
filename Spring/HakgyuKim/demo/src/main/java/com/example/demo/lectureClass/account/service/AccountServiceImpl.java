package com.example.demo.lectureClass.account.service;

import com.example.demo.lectureClass.account.entity.MemberAccount;
import com.example.demo.lectureClass.account.repository.AccountRepository;
import com.example.demo.lectureClass.account.service.request.AccountRegisterRequest;
import com.example.demo.lectureClass.afterLogin.controller.form.AccountResponseForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final private AccountRepository accountRepository;

    @Override
    public Boolean checkEmailDuplication(String email) {
        Optional<MemberAccount> maybeAccount = accountRepository.findByEmail(email);

        if (maybeAccount.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean signUp(AccountRegisterRequest request) {
        accountRepository.save(request.toAccount());

        return true;
    }

    @Override
    public Long findAccountIdByEmail(String email) {
        if (email == null) {
            return -1L;
        }

        final Optional<MemberAccount> maybeAccount = accountRepository.findByEmail(email);

        if (maybeAccount.isEmpty()) {
            return -1L;
        }

        return maybeAccount.get().getId();
    }

    @Override
    public Long signUpWithEmail(String email) {
        final Optional<MemberAccount> maybeAccount = accountRepository.findByEmail(email);

        if (maybeAccount.isPresent()) {
            return maybeAccount.get().getId();
        }

        final MemberAccount account = new MemberAccount(email);

        return accountRepository.save(account).getId();
    }

    @Override
    public AccountResponseForm findAccountInfoById(Long accountId) {
        Optional<MemberAccount> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()) {
            log.info("계정 존재 하지 않습니다");
            return null;
        } else {

            final MemberAccount account = maybeAccount.get();
            final AccountResponseForm responseForm = new AccountResponseForm(account.getEmail());
            log.info("account: " + account);
            return responseForm;
        }
    }
}
