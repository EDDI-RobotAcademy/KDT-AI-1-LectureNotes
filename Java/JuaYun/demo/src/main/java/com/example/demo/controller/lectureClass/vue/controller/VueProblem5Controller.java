package com.example.demo.controller.lectureClass.vue.controller;

import com.example.demo.controller.lectureClass.vue.controller.form.GameAccountForm;
import com.example.demo.controller.lectureClass.vue.controller.form.LoginResponseForm;
import com.example.demo.controller.lectureClass.vue.controller.form.RequestAccountIdForm;
import com.example.demo.controller.lectureClass.vue.entity.GameAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bmp-account")
public class VueProblem5Controller {

    // 어떻게 중복인지 판정할 것인가?
    private final List<GameAccount> gameAccountList = new ArrayList<>();
    private static Long gameAccountId = 1L;

// 프론트가 없어도 백엔드를 포스트맨으로 검증할 수 있음
//{
//    "email": "test@test.com" ,
//    "password" : "test"
//}
// 포스트맨에 위와 같은 형태로 이메일을 직접 설정해줘야 오류가 나지않고 돌아간다.
    @PostMapping("/create")
    // 이메일 중복판정을 위해 Boolean 으로 설정
    public Boolean createGameAccount(@RequestBody GameAccountForm gameAccountForm) {
        log.info("createGameAccount()");


        final GameAccount gameAccount = gameAccountForm.toGameAccount(gameAccountId++);

        // 이메일 중복체크
        for (int i = 0; i < gameAccountList.size(); i++) {
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if (gameAccount.getEmail().equals(searchedGameAccountEmail)) {
                return true;
            }
        }

        gameAccountList.add(gameAccount);

        return false;
    }

    @PostMapping("/login")
    // 이메일 중복판정을 위해 Boolean 으로 설정
    public LoginResponseForm gameAccountLogin (@RequestBody GameAccountForm gameAccountForm) {
        log.info("gameAccountLogin()");

        final Long LOGIN_FAILED_ACCOUNT_ID = 0L;

        // 이메일확인
        for (int i = 0; i < gameAccountList.size(); i++) {
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if (searchedGameAccountEmail.equals(gameAccountForm.getEmail())) {
                if (searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())) {
                    return new LoginResponseForm(true, searchedGameAccount.getId());
                }
                // 계정이 없어서 false
                return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
            }
        }

        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
    }

    @PostMapping("/find-account-info")
    public String findAccountInfo (@RequestBody RequestAccountIdForm requestAccountIdForm) {
        final int LIST_BIAS = 1;
        log.info("findAccountInfo()");

        final GameAccount foundGameAccount = gameAccountList.get(
                (int) (requestAccountIdForm.getGameAccountId() - LIST_BIAS));

        return foundGameAccount.getEmail();
    }
}
