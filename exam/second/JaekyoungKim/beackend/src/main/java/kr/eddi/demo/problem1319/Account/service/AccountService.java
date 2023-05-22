package kr.eddi.demo.problem1319.Account.service;

import kr.eddi.demo.RefactorAccount.service.request.AccountRegisterRequest;
import kr.eddi.demo.problem1319.Account.controller.form.AccountLoginResponseForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountRequestForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountWithBusinessRoleRequestForm;
import kr.eddi.demo.problem1319.Account.controller.form.AccountWithNormalRoleRequestForm;
import kr.eddi.demo.problem1319.Account.entity.Account;

public interface AccountService {
    Account normalMemberRegister(AccountWithNormalRoleRequestForm requestForm);

    Account businessMemberRegister(AccountWithBusinessRoleRequestForm requestForm);

    AccountLoginResponseForm login(AccountRequestForm requestForm);

    Boolean isBusiness(String email);

}
