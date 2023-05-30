package com.example.demo.exam.exam10To30.account.service;

import com.example.demo.exam.exam10To30.account.service.request.AccountRegisterRequest;
import com.example.demo.exam.exam10To30.account.entity.Account;
import com.example.demo.exam.exam10To30.account.entity.AccountRole;
import com.example.demo.exam.exam10To30.account.entity.Role;
import com.example.demo.exam.exam10To30.account.repository.AccountRepository;
import com.example.demo.exam.exam10To30.account.repository.AccountRoleRepository;
import com.example.demo.exam.exam10To30.account.repository.RoleRepository;
import com.example.demo.exam.exam10To30.account.form.LoginRequestForm;
import com.example.demo.exam.exam10To30.account.form.LoginResponseForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.exam.exam10To30.account.entity.RoleType.BUSINESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Boolean register(AccountRegisterRequest requestForm) {
        final Optional<Account> maybeAccount = accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 이메일입니다.");
            return false;
        }
        final Account account = accountRepository.save(requestForm.toAccount());

        final Role role = roleRepository.findByRoleType(requestForm.getRoleType());
        final AccountRole accountRole = new AccountRole(account, role, requestForm.getBusinessNumber());

        accountRoleRepository.save(accountRole);
        return true;
    }

    @Override
    public LoginResponseForm login(LoginRequestForm requestForm) {
        final Optional<Account> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isEmpty()) {
            log.debug("로그인 실패");
            return null;
        }

        Account account = maybeAccount.get();

        if (account.getPassword().equals(requestForm.getPassword())) {
            log.debug("로그인 성공!");
            return new LoginResponseForm(account.getId());
        }

        return null;
    }

    @Override
    public Boolean checkRole(LoginResponseForm responseForm) {
        AccountRole accountRole = accountRoleRepository.findByAccountId(responseForm.getAccountId());
        if (accountRole.getRole().getRoleType() == BUSINESS) {
            return true;
        }
        return false;
    }
}

