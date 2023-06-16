package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.AccountLogInForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.AccountMultiResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.AccountCreationForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.CharacterListForm;
import kr.eddi.demo.lectureClass.vue.problem.entity.Account;
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
    private static int logInAccountId;
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

        logInAccountId = emailIdMap.get(accountLogInForm.getUserEmail());

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
    public Boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
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

//    @PostMapping("/create-character")
//    public Boolean createCharacter (@RequestBody CharacterCreationForm characterCreationForm) {
//        log.info("createAccount(): " + characterCreationForm);
//        final Character character =
//                characterCreationForm.toCharacter(
//                        characterCreationForm.getSelectedGender(),
//                        characterId,
//                        logInAccountId
//                );
//        characterStatusList.add(character);
//        multiIdMap.add(logInAccountId, characterId);
//        characterId++;
//        log.info("characterStatusList: " + characterStatusList);
//        return true;
//    }
//
//    @PostMapping("/get-character-id")
//    public List<Integer> getCharacterId (@RequestBody CharacterCreationForm characterCreationForm) {
//        log.info("requestCharacterId: " + characterCreationForm.getMyAccountId());
//        log.info("multiIdMap: " + multiIdMap);
//        log.info("logInAccountId: " + logInAccountId);
//        log.info("value: " + multiIdMap.get(logInAccountId));
//        List<Integer> characterList = multiIdMap.get(logInAccountId);
//        return multiIdMap.get(logInAccountId);
//    }

    @PostMapping("/get-character-info")
    public List<Character> getCharacterStatus (@RequestBody CharacterListForm characterListForm) {
        log.info("getCharacterStatus()");
        return characterStatusList;
    }
}
