package kr.eddi.demo.problem1319.Account.service;

import kr.eddi.demo.RefactorAccount.entity.RefactorAccount;
import kr.eddi.demo.RefactorAccount.service.request.AccountRegisterRequest;
import kr.eddi.demo.problem1319.Account.controller.form.AccountLoginResponseForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountRequestForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountWithBusinessRoleRequestForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountWithNormalRoleRequestForm;
import kr.eddi.demo.problem1319.Account.entity.Account;
import kr.eddi.demo.problem1319.Account.entity.BusinessAccountRole;
import kr.eddi.demo.problem1319.Account.repository.AccountRepository;
import kr.eddi.demo.problem1319.Account.repository.BusinessAccountRoleRepository;
import kr.eddi.demo.problem1319.Account.repository.NormalAccountRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
   final private AccountRepository accountRepository;
   final private NormalAccountRoleRepository normalAccountRoleRepository;
   final private BusinessAccountRoleRepository businessAccountRoleRepository;
    @Override
    public Account normalMemberRegister(AccountWithNormalRoleRequestForm requestForm) {
        final Optional<Account> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }


        final Account account = accountRepository.save(requestForm.toAccount());

        normalAccountRoleRepository.save(requestForm.toAccountRole(account));
        return account;
    }

    @Override
    public Account businessMemberRegister(AccountWithBusinessRoleRequestForm requestForm) {
        final Optional<Account> maybeAccount =
                accountRepository.findByEmail(requestForm.getEmail());

        if (maybeAccount.isPresent()) {
            log.debug("이미 가입된 회원입니다!");
            return null;
        }


        final Account account = accountRepository.save(requestForm.toAccount());

        businessAccountRoleRepository.save(requestForm.toAccountRole(account));
        return account;
    }

    @Override
    public AccountLoginResponseForm login(AccountRequestForm requestForm) {
        final Optional<Account> maybeAccount =accountRepository.findByEmail(requestForm.getEmail());
        if (maybeAccount.isEmpty()){
            log.debug("로그인이 불가능 합니다.");
            return new AccountLoginResponseForm(null);
        }
        Account account=maybeAccount.get();
        if (account.getPassword().equals(requestForm.getPassword())){
            log.debug("로그인 성공");
            return new AccountLoginResponseForm(UUID.randomUUID());
        }
        return new AccountLoginResponseForm(null);
    }

    @Override
    public Boolean isBusiness(String email) {
       final Optional<Account> maybeAccount=accountRepository.findByEmail(email);
        if (maybeAccount.isEmpty()){
            log.debug("회원 아닙니다.");
            return false;
        }
        Account account=maybeAccount.get();
        final Optional<BusinessAccountRole> maybeBusiness=businessAccountRoleRepository.findByAccountId(account.getId());
        if (maybeBusiness.isEmpty()){
            log.debug("사업자 아닙니다.");
            return false;
        } else {
            return true;
        }

    }

}
