package kr.eddi.demo.account.service;

import kr.eddi.demo.account.service.accountRegisterRequest.AccountRegisterRequest;

public interface AccountService {
    Boolean checkEmailDuplication(String email);

    Boolean signUp(AccountRegisterRequest request);

    Long findAccountIdByEmail(String email);

    Long signUpWithEmail(String email);
}