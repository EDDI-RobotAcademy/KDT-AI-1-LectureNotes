package kr.eddi.demo.RefactorAccount.service;

import kr.eddi.demo.RefactorAccount.entity.RefactorAccount;
import kr.eddi.demo.RefactorAccount.entity.RefactorAccountRole;
import kr.eddi.demo.RefactorAccount.entity.RefactorRole;

import kr.eddi.demo.RefactorAccount.entity.RoleType;
import kr.eddi.demo.RefactorAccount.repository.RefactorAccountRepository;
import kr.eddi.demo.RefactorAccount.repository.RefactorAccountRoleRepository;
import kr.eddi.demo.RefactorAccount.repository.RefactorRoleRepository;
import kr.eddi.demo.RefactorAccount.repository.UserTokenRepository;
import kr.eddi.demo.RefactorAccount.service.request.AccountRegisterRequest;
import kr.eddi.demo.RefactorAccount.service.request.RequestAccountLoginRequest;
import kr.eddi.demo.problem1319.Account.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefactorAccountServiceImpl implements RefactorAccountService{

    final private RefactorAccountRepository accountRepository;
    final private RefactorRoleRepository roleRepository;

    final private RefactorAccountRoleRepository accountRoleRepository;
    final private UserTokenRepository userTokenRepository;
    @Override
    public Boolean refactorRegister(AccountRegisterRequest accountRegisterRequest) {
        final Optional<RefactorAccount> maybeAccount= accountRepository.findByEmail(accountRegisterRequest.getEmail());
       if (maybeAccount.isPresent()){
           return false;
       }
       final RefactorAccount account=accountRepository.save(accountRegisterRequest.toAccount());
       final RefactorRole role=roleRepository.findByRoleType(accountRegisterRequest.getRoleType()).get();

       final RefactorAccountRole accountRole= new RefactorAccountRole(account,role);
        accountRoleRepository.save(accountRole);

        return true;
    }

    @Override
    public String login(RequestAccountLoginRequest accountLoginRequest) {
        final Optional<RefactorAccount> maybeAccount= accountRepository.findByEmail(accountLoginRequest.getEmail());
        if (maybeAccount.isEmpty()){
            return null;
        }
        final RefactorAccount account=maybeAccount.get();
        if (account.getPassword().equals(accountLoginRequest.getPassword())){
            final String userToken= UUID.randomUUID().toString();
            userTokenRepository.save(userToken,account.getId());

            return userToken;
        }
        return null;

    }

    @Override
    public RoleType lookup(String userToken) {
    final Long accountId = userTokenRepository.findRoleByToken(userToken);
    Optional<RefactorAccount> maybeAccount=accountRepository.findById(accountId);

    if (maybeAccount.isEmpty()){
        return null;
    }
    final RefactorAccount account= maybeAccount.get();
    final RefactorRole role= accountRoleRepository.findByInfoByAccount(account);

    return role.getRoleType();

    }
}
