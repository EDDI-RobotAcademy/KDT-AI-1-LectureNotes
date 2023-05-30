package kr.eddi.demo.lectureClass.vue.problem4.controller;


import kr.eddi.demo.lectureClass.vue.problem4.controller.entitiy.Account;
import kr.eddi.demo.lectureClass.vue.problem4.controller.entitiy.CharacterStatus;
import kr.eddi.demo.lectureClass.vue.problem4.controller.form.AccountCreationForm;
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
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();

    @PostMapping("/create")
    public Boolean createAccount(@RequestBody AccountCreationForm accountCreationForm) {
        log.info("createAccount(): " + accountCreationForm);

        final Account account = accountCreationForm.toAccount(accountNumber);
        accountNumber++;

        accountList.add(account);

        final CharacterStatus characterStatus = new CharacterStatus(account.getId());
        characterStatusList.add(characterStatus);

        return true;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus () {
        log.info("getCharacterStatus() ");

        return characterStatusList.get(0);
    }
}
