package com.example.demo.problem10.service;

import com.example.demo.problem10.controller.form.AccountWithRoleRequestForm;
import com.example.demo.problem10.controller.form.BusinessNumberRequestForm;
import com.example.demo.problem10.entity.Member;
import com.example.demo.problem17.controller.form.AccountLoginResponseForm;
import com.example.demo.problem17.controller.form.AccountRequestForm;

public interface AccountService {
    Member registerWithRole(AccountWithRoleRequestForm requestForm);

    Member registerWithRoleAndNumber(AccountWithRoleRequestForm requestForm, String businessNumber);

    AccountLoginResponseForm login(AccountRequestForm requestForm);
}
