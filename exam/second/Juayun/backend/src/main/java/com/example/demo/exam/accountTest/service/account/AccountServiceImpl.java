package com.example.demo.exam.accountTest.service.account;

import com.example.demo.exam.accountTest.controller.request.account.AccountLoginRequest;
import com.example.demo.exam.accountTest.controller.request.account.AccountRegisterRequest;
import com.example.demo.exam.accountTest.entity.account.Account;
import com.example.demo.exam.accountTest.entity.account.AccountRole;
import com.example.demo.exam.accountTest.entity.Role;
import com.example.demo.exam.accountTest.repository.UserTokenRepository;
import com.example.demo.exam.accountTest.repository.UserTokenRepositoryImpl;
import com.example.demo.exam.accountTest.repository.account.AccountRepository;
import com.example.demo.exam.accountTest.repository.account.AccountRoleRepository;
import com.example.demo.exam.accountTest.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final private AccountRepository accountRepository;
    final private RoleRepository roleRepository;
    final private AccountRoleRepository accountRoleRepository;

    final private UserTokenRepository userTokenRepository = UserTokenRepositoryImpl.getInstance();

    @Override
    public Boolean register(AccountRegisterRequest toAccountRegisterRequest) {
        // 여기서 등록해야 하는것은 roleType, account, accountRole

        Account account = accountRepository.save(toAccountRegisterRequest.toAccount());

        final Role role =
                roleRepository.findByRoleType(toAccountRegisterRequest.getRoleType()).get();
        // 여기서 끝에 get() 을 사용한 이유는 findByRole 을 Repository 에서 Optional 로 찾기 때문

        // 이 부분을 Role 클래스를 가져온 위로 올렸었는데 role 에 오류가 생김
        // 클래스를 불러오고 사용해야됨
        final AccountRole accountRole = new AccountRole(account, role);
        accountRoleRepository.save(accountRole);

        account.setAccountRole(accountRole);

        return true;
    }

    @Override
    public String login(AccountLoginRequest toAccountLoginRequest) {
        final Optional<Account> maybeAccount =
                accountRepository.findByEmail(toAccountLoginRequest.getEmail());
        if (maybeAccount.isEmpty()) {
            return null;
        }

        final Account account = maybeAccount.get();
        if (account.getPassword().equals(toAccountLoginRequest.getPassword())) {
            final String userToken = UUID.randomUUID().toString();
            userTokenRepository.save(userToken, account.getId());

            return userToken;
        }
        return null;
    }
}
