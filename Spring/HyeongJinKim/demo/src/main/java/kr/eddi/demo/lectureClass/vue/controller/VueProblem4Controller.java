package kr.eddi.demo.lectureClass.vue.controller;

import kr.eddi.demo.lectureClass.vue.controller.form.AccountLogInForm;
import kr.eddi.demo.lectureClass.vue.controller.form.AccountMultiResponseForm;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.*;
import kr.eddi.demo.lectureClass.vue.controller.form.AccountCreationForm;
import kr.eddi.demo.lectureClass.vue.controller.form.gameCharacter.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/new-character")
public class VueProblem4Controller {
    private static int accountNumber = 1;
    private static int characterId = 1;
    private static List<Account> accountList = new ArrayList<>();
    private static List<Character> characterStatusList = new ArrayList<>();
    HashMap<String, String> emailPwMap = new HashMap<>();
    HashMap<String, Integer> emailIdMap = new HashMap<>();
    MultiValueMap<Integer, Integer> multiIdMap = new LinkedMultiValueMap<>();

    @PostMapping("/sign-in")
    public AccountMultiResponseForm logIn (@RequestBody AccountLogInForm accountLogInForm) {
        log.info("received data: " + accountLogInForm);

        // 계정마다 다른 accountId가 부여되는지 확인
        log.info("accountID: " + emailIdMap.get(accountLogInForm.getUserEmail()));

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        if (emailPwMap.containsKey(accountLogInForm.getUserEmail())) {
            if (Objects.equals(emailPwMap.get(accountLogInForm.getUserEmail()), accountLogInForm.getUserPw())) {
                return new AccountMultiResponseForm(
                        true,
                        accountLogInForm.getUserEmail(),
                        emailIdMap.get(accountLogInForm.getUserEmail())
                );
            }
        }
        return new AccountMultiResponseForm(false, null, null);
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

            // 회원가입 시 각각의 Map에 Password, accountId 저장
            emailPwMap.put(accountCreationForm.getNewEmail(), accountCreationForm.getNewPw());
            emailIdMap.put(accountCreationForm.getNewEmail(), accountNumber);

            accountNumber++;

        return true;
        }
    }

    @PostMapping("/create-character")
    public Boolean createCharacter (@RequestBody CharacterCreationForm characterCreationForm) {
        log.info("createAccount(): " + characterCreationForm);

        final Character character =
                characterCreationForm.toCharacter(
                        characterCreationForm.getSelectedGender(),
                        characterId,
                        characterCreationForm.getAccountId()
                );
//        CharacterCreationForm characterCreationForm = new characterCreationForm(
//                character.getSelectedGender(),
//                character.getCharacterId()
//        );

        // 계정의 Id값을 key로, 캐릭터의 Id값을 value로
        // 증가된 accountNumber값을 받는다.
        // -> 계정의 accountNumber을 받아서 Map에 추가하게 변경 필요
//        int accountId = emailIdMap.get(accountList.get(
//                characterCreationForm.getAccountId()).getAccountId()
//        );
        multiIdMap.add(characterCreationForm.getAccountId(), characterId);

        characterId++;

        characterStatusList.add(character);
        log.info("characterStatusList: " + characterStatusList);

        return true;
    }

    @PostMapping("/get-character-id")
    public List<Integer> getCharacterId (@RequestBody RequestCharacterId requestCharacterId) {
        log.info("requestCharacterId: " + requestCharacterId.getMyAccountId());
        log.info("multiIdMap: " + multiIdMap);
        log.info("value: " + multiIdMap.get(requestCharacterId.getMyAccountId() - 1));
        return multiIdMap.get(requestCharacterId.getMyAccountId() - 1);
    }

    @GetMapping("/get-character-info")
    public Character getCharacterStatus () {
        log.info("getCharacterStatus()");
        return characterStatusList.get(0);
    }
}
