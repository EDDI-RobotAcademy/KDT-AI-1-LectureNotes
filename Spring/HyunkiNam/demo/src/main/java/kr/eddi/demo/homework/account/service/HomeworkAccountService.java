package kr.eddi.demo.homework.account.service;

import kr.eddi.demo.homework.account.entity.HomeworkAccount;
import kr.eddi.demo.homework.account.controller.form.HomeworkAccountWithRoleRequestForm;

public interface HomeworkAccountService {
    HomeworkAccount register(HomeworkAccountWithRoleRequestForm requestForm);

}