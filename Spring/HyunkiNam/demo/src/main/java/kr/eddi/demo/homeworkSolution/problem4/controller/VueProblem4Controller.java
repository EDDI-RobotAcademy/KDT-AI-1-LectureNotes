package kr.eddi.demo.homeworkSolution.problem4.controller;

import kr.eddi.demo.homeworkSolution.problem4.controller.form.AccountCreationForm;
import kr.eddi.demo.homeworkSolution.problem4.entity.Account;
import kr.eddi.demo.homeworkSolution.problem4.entity.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test-account")
public class VueProblem4Controller {

    private static Long accountNumber = 1L;
    private static List<Account> accountList = new ArrayList<>();
    // private static List<CharacterStatus> characterStatusList = new ArrayList<>();

    final private static Map<Long, CharacterStatus> characterStatusMap = new HashMap<>();

    @PostMapping("/create")
    public Boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
        log.info("createAccount(): " + accountCreationForm);

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        final Account account = accountCreationForm.toAccount(accountNumber);
        accountNumber++;
        accountList.add(account);

        final CharacterStatus characterStatus = new CharacterStatus(account.getId());
        characterStatusMap.put(account.getId(),characterStatus);
        // characterStatusList.add(characterStatus);


        return true;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus (@RequestParam Long playerNumber) {
        log.info("getCharacterStatus()");
        // return characterStatusList.get(0);
        return characterStatusMap.get(playerNumber);
    }
}