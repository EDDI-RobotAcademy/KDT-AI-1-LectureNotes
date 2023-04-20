package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.AccountCreationForm;
import kr.eddi.demo.lectureClass.vue.problem.entity.Account;
import kr.eddi.demo.lectureClass.vue.problem.entity.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test-account")
public class VueProblem4Controller {

    private static Long accountNumber = 1L;
    private static List<Account> accountList = new ArrayList<>();

    @PostMapping("/create")
    public Boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
        log.info("createAccount(): " + accountCreationForm);

        final Account account = accountCreationForm.toAccount(accountNumber);
        accountNumber++;

        accountList.add(account);

        return true;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus () {
        log.info("getCharacterStatus()");

        return null;
    }
}
