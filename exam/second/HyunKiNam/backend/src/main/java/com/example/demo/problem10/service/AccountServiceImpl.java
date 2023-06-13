package com.example.demo.problem10.service;

import com.example.demo.problem10.controller.form.AccountLoginRequestForm;
import com.example.demo.problem10.controller.form.AccountLoginResponseForm;
import com.example.demo.problem10.controller.form.AccountRequestForm;
import com.example.demo.problem10.entity.Account;
import com.example.demo.problem10.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final private AccountRepository accountRepository;

    @Override
    public Account register(AccountRequestForm requestForm) {
        final Optional<Account> maybeAccount = accountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isPresent()){
            return null;
        }

        final Account account = requestForm.toAccount();
        accountRepository.save(account);

        return account;
    }

    @Override
    public AccountLoginResponseForm login(AccountLoginRequestForm requestForm) {
        final Optional<Account> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());
        if (maybeAccount.isEmpty()) {
            log.debug("로그인 실패!");
            return new AccountLoginResponseForm(null, false);
        }
        Account account = maybeAccount.get();
        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            if(account.getCompanyNumber()!=null){
                return new AccountLoginResponseForm(account.getId(),true);
            }
            return new AccountLoginResponseForm(account.getId(),false);

        }

        return new AccountLoginResponseForm(null, false);
    }
}
