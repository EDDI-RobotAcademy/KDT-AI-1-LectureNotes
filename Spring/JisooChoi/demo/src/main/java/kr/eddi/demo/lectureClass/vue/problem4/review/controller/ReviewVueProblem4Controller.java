package kr.eddi.demo.lectureClass.vue.problem4.review.controller;

import kr.eddi.demo.lectureClass.vue.problem4.review.controller.form.AccountCreationForm;
import kr.eddi.demo.lectureClass.vue.problem4.review.controller.form.AccountLoginForm;
import kr.eddi.demo.lectureClass.vue.problem4.review.entity.Account;
import kr.eddi.demo.lectureClass.vue.problem4.review.entity.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test-account")
public class ReviewVueProblem4Controller {

    private static Long accountNumber = 1L;
    private static List<Account> accountList = new ArrayList<>();
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();

    @PostMapping("/create")
    public Boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
        log.info("createAccount(): " + accountCreationForm);

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        final Account account = accountCreationForm.toAccount(accountNumber);
        accountList.add(account);
        accountNumber++;

        final CharacterStatus characterStatus = new CharacterStatus(account.getId());
        characterStatusList.add(characterStatus);

        return true;
    }

    @PostMapping("/find-user")
    public String findAccount (@RequestBody AccountLoginForm accountLoginForm){
        log.info("AccountLoginForm()이 잘 전달되는지 확인: " +accountLoginForm);

        for(int i = 0; i< accountList.size(); i++){
            if(accountList.get(i).getEmail().equals(accountLoginForm.getLoginUserEmail())){
                log.info("기존에 존재한 아이디: "+accountList.get(i).getEmail() + ", 현재 내가 입력한 아이디: "+ accountLoginForm.getLoginUserEmail());
                return accountList.get(i).getEmail();
            }
        }
        log.info("계정이 없습니다.");
        return null;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus () {
        for(int i = 0; i < characterStatusList.size(); i++){
            log.info("getCharacterStatus(): " +characterStatusList.get(i));
        }

        return characterStatusList.get(0);
    }
}
