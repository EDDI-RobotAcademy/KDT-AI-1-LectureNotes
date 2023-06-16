package kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service;

import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.repository.AuthAccountRepository;
import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service.form.AccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthAccountServiceImpl implements AuthAccountService{
    final AuthAccountRepository accountRepository;
    @Override
    public Boolean singUp(AccountRegisterRequest request) {
        accountRepository.save(request.toAccount());
        return true;
    }
}
