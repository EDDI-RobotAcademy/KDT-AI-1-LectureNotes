package kr.eddi.demo.lectureClass.vue.controller;

import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.Account;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.CharacterStatus;
import kr.eddi.demo.lectureClass.vue.controller.form.AccountCreationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/new-character")
public class VueProblem4Controller {
    private static int accountNumber = 1;
    private static List<Account> accountList = new ArrayList<>();
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();

    @PostMapping("/create-character-info")
    public boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
        log.info("received data: " + accountCreationForm);

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        final Account account = accountCreationForm.toAccount(accountNumber);
        accountNumber++;
        accountList.add(account);

        final CharacterStatus characterStatus = new CharacterStatus(account.getAccountId());
        // @Getter로 가져온 변수 이름 변경 시 주의

        characterStatusList.add(characterStatus);

        return true;
    }

    @GetMapping("/get-character-info")
    public CharacterStatus getCharacterStatus () {
        log.info("getCharacterStatus()");
        return characterStatusList.get(0);
    }
}
