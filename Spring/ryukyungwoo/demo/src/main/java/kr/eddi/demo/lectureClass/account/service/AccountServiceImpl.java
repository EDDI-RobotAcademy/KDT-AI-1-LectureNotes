package kr.eddi.demo.lectureClass.account.service;

import kr.eddi.demo.lectureClass.account.controller.form.AccountResponseForm;
import kr.eddi.demo.lectureClass.account.entity.MemberAccount;
import kr.eddi.demo.lectureClass.account.repository.AccountRepository;
import kr.eddi.demo.lectureClass.account.service.request.AccountRegisterRequest;
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
        final Optional<MemberAccount> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()) {
            log.info("이런 계정은 존재하지 않습니다(해킹이 의심됩니다!)");
            return null;
        }

        final MemberAccount account = maybeAccount.get();
        final AccountResponseForm responseForm = new AccountResponseForm(account.getEmail());

        return responseForm;
    }
}
