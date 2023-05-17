package kr.eddi.demo.homework.account.controller;

import kr.eddi.demo.homework.account.controller.form.HomeworkAccountWithRoleRequestForm;
import kr.eddi.demo.homework.account.entity.HomeworkAccount;
import kr.eddi.demo.homework.account.service.HomeworkAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    final private HomeworkAccountService accountService;

    @PostMapping("/register")
    public void accountRegister(@RequestBody HomeworkAccountWithRoleRequestForm requestForm){

        accountService.register(requestForm);
    }
}
