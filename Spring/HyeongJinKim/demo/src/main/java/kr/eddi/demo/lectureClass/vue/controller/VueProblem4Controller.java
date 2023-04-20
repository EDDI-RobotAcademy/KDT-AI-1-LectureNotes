package kr.eddi.demo.lectureClass.vue.controller;

import kr.eddi.demo.lectureClass.vue.controller.form.AccountLogInForm;
import kr.eddi.demo.lectureClass.vue.controller.form.AccountMultiResponseForm;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.Account;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.Character;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.CharacterCreationForm;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.CharacterStatus;
import kr.eddi.demo.lectureClass.vue.controller.form.AccountCreationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/new-character")
public class VueProblem4Controller {
    private static int accountNumber = 1;
    private static int characterId = 1;
    private static List<Account> accountList = new ArrayList<>();
    private static List<Character> characterList = new ArrayList<>();
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();
    HashMap<String, String> emailPwMap = new HashMap<>();

    @PostMapping("/sign-in")
    public AccountMultiResponseForm logIn (@RequestBody AccountLogInForm accountLogInForm) {
        log.info("received data: " + accountLogInForm);

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        if (emailPwMap.containsKey(accountLogInForm.getUserEmail())) {
            if (Objects.equals(emailPwMap.get(accountLogInForm.getUserEmail()), accountLogInForm.getUserPw())) {
                return new AccountMultiResponseForm(
                        true, accountLogInForm.getUserEmail()
                );
            }
        }
        return new AccountMultiResponseForm(false, "한글은못쳐");
    }

    @PostMapping("/sign-up")
    public boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
        log.info("received data: " + accountCreationForm);

        if (emailPwMap.containsKey(accountCreationForm.getNewEmail())) {
            return false;
        }
        else {
            // 리스트는 트리 기반의 검색을 합니다.
            // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
            final Account account = accountCreationForm.toAccount(accountNumber);
            accountList.add(account);

            emailPwMap.put(accountCreationForm.getNewEmail(), accountCreationForm.getNewPw());

            accountNumber++;

        return true;
        }
    }

    @PostMapping("/create-character")
    public Boolean createAccount (@RequestBody CharacterCreationForm characterCreationForm) {
        log.info("createAccount(): " + characterCreationForm);

        final Character character =
                characterCreationForm.toCharacter(
                        characterCreationForm.getGender(), characterId);
        characterId++;
        characterList.add(character);

        final CharacterStatus characterStatus = new CharacterStatus(character.getGender(), character.getCharacterId());
        characterStatusList.add(characterStatus);

        return true;
    }

    @GetMapping("/get-character-info")
    public CharacterStatus getCharacterStatus () {
        log.info("getCharacterStatus()");
        return characterStatusList.get(0);
    }
}
