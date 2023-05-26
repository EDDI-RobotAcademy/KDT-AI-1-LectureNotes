package com.example.demo.problem11.service;

import com.example.demo.problem11.entity.BusinessAccount;
import com.example.demo.problem11.entity.NormalAccount;
import com.example.demo.problem11.entity.Role;
import com.example.demo.problem11.repository.BusinessAccountRepository;
import com.example.demo.problem11.repository.NormalAccountRepository;
import com.example.demo.problem11.repository.RoleRepository;
import com.example.demo.problem11.service.request.BusinessAccountRegisterRequest;
import com.example.demo.problem11.service.request.NormalAccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    final private NormalAccountRepository normalAccountRepository;
    final private BusinessAccountRepository businessAccountRepository;
    final private RoleRepository roleRepository;
//    final private AccountRoleRepository accountRoleRepository;

    @Override
    public Boolean registerNormalAccount(NormalAccountRegisterRequest request) {

        final Optional<NormalAccount> maybeAccount = normalAccountRepository.findByEmail(request.getEmail());
        if (maybeAccount.isPresent()) {
            return false;
        }

        final NormalAccount normalAccount = normalAccountRepository.save(request.toNormalAccount());
//        final Role role = roleRepository.findByRoleType(
//                request.getRoleType()).get();
//        final AccountRole accountRole =
//                new AccountRole(normalAccount, null, role);
//        accountRoleRepository.save(accountRole);

        return true;
    }

    @Override
    public Boolean registerBusinessAccount(BusinessAccountRegisterRequest businessAccountRegisterRequest) {

        final Optional<BusinessAccount> maybeBusinessAccount =
                businessAccountRepository.findByEmail(businessAccountRegisterRequest.getEmail());
        if (maybeBusinessAccount.isPresent()) {
            return false;
        }

        final BusinessAccount businessAccount =
                businessAccountRepository.save(businessAccountRegisterRequest.toBusinessAccount());
        final Role role = roleRepository.findByRoleType(
                businessAccountRegisterRequest.getRoleType()).get();
//        final AccountRole accountRole =
//                new AccountRole(null, businessAccount, role);
//        accountRoleRepository.save(accountRole);

        return true;
    }
}
