package com.example.demo.evaluation.problem10_14_17_20.service;

import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginResponseForm;
import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.entity.AccountRole;
import com.example.demo.evaluation.problem10_14_17_20.entity.Role;
import com.example.demo.evaluation.problem10_14_17_20.repository.AccountRepository;
import com.example.demo.evaluation.problem10_14_17_20.repository.AccountRoleRepository;
import com.example.demo.evaluation.problem10_14_17_20.repository.RoleRepository;
import com.example.demo.evaluation.problem10_14_17_20.service.request.BusinessAccountRegisterRequest;
import com.example.demo.evaluation.problem10_14_17_20.service.request.NormalAccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public Account normalRegister(NormalAccountRegisterRequest normalAccountRegisterRequest) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(normalAccountRegisterRequest.getEmail());

        if(maybeAccount.isPresent()) {
            log.info("이미 가입된 회원입니다.");
            return null;
        }

        final Account account =
                new Account(
                        normalAccountRegisterRequest.getEmail(),
                        normalAccountRegisterRequest.getPassword());

        accountRepository.save(account);

        final Role role = roleRepository.findByRoleType(normalAccountRegisterRequest.getRoleType());
        final AccountRole accountRole = new AccountRole(role, account);

        accountRoleRepository.save(accountRole);

        return account;
    }

    @Override
    public Account businessRegister(BusinessAccountRegisterRequest businessAccountRegisterRequest) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(businessAccountRegisterRequest.getEmail());

        if(maybeAccount.isPresent()) {
            log.info("이미 가입된 회원입니다.");
            return null;
        }

        final Account account =
                new Account(
                        businessAccountRegisterRequest.getEmail(),
                        businessAccountRegisterRequest.getPassword(),
                        businessAccountRegisterRequest.getBusinessNumber());

        accountRepository.save(account);

        final Role role = roleRepository.findByRoleType(businessAccountRegisterRequest.getRoleType());
        final AccountRole accountRole = new AccountRole(role, account);

        accountRoleRepository.save(accountRole);

        return account;
    }

    @Override
    public AccountLoginResponseForm login(AccountLoginRequestForm accountLoginRequestForm) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(accountLoginRequestForm.getEmail());

        if(maybeAccount.isPresent()) {
            if(accountLoginRequestForm.getPassword().equals(maybeAccount.get().getPassword())) {
                return new AccountLoginResponseForm(UUID.randomUUID());
            }
        }

        return new AccountLoginResponseForm(null);
    }
}
