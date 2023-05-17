package com.example.demo.exam.refactorAccount.service;

import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessLoginResponseForm;
import com.example.demo.exam.refactorAccount.controller.form.AccountBusinessRegisterRequestForm;
import com.example.demo.exam.refactorAccount.entity.AccountBusiness;
import com.example.demo.exam.refactorAccount.repository.AccountBusinessRepository;
import com.example.demo.exam.refactorAccount.form.AccountBusinessRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountBusinessServiceImpl implements AccountBusinessService {

    final private AccountBusinessRepository accountBusinessRepository;

    @Override
    public AccountBusiness register(AccountBusinessRegisterRequest request) {
        final Optional<AccountBusiness> maybeAccount =
                accountBusinessRepository.findByEmail(request.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다.");
            return null;
        }

        final AccountBusiness business = accountBusinessRepository.save(request.toAccountBusiness());
        // 바로 리턴하지않음
        accountBusinessRepository.save(request.toAccountBusiness());

        return business;
    }

    @Override
    public AccountBusinessLoginResponseForm login(AccountBusinessRegisterRequestForm requestForm) {
        final Optional<AccountBusiness> maybeAccount =
                accountBusinessRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            log.debug("로그인 실패!");
            return new AccountBusinessLoginResponseForm(null);
        }
        AccountBusiness account = maybeAccount.get();

        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            return new AccountBusinessLoginResponseForm(UUID.randomUUID());
        }
        return new AccountBusinessLoginResponseForm(null);
    }
} // Repository 에 final 안붙이면 무조건 오류남

