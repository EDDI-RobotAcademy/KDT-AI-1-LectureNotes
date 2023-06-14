package kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service;

import kr.eddi.demo.lectureClass.gitAuth.GitAuthAccount.service.form.AccountRegisterRequest;

public interface AuthAccountService {
    Boolean singUp(AccountRegisterRequest request);
}
