package kr.eddi.demo.lectureClass.account.service;

import kr.eddi.demo.lectureClass.account.service.request.AccountRegisterRequest;

public interface AccountService {
    Boolean checkEmailDuplication(String email);

    Boolean signUp(AccountRegisterRequest request);
}