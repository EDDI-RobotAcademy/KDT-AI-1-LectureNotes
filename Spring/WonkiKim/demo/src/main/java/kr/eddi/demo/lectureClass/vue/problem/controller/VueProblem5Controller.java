package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.GameAccountForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.LoginResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.RequestAccountIdForm;
import kr.eddi.demo.lectureClass.vue.problem.entity.GameAccount;
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

    // 어떻게 중복인지 판정할 것인가 ?
    private final List<GameAccount> gameAccountList = new ArrayList<>();
    private static Long gameAccountId = 1L;

    @PostMapping("/create")
    public Boolean createGameAccount (@RequestBody GameAccountForm gameAccountForm) {
        log.info("createGameAccount()");

        final GameAccount gameAccount = gameAccountForm.toGameAccount(gameAccountId++);

        if (checkDuplicatedEmail(gameAccount))
            return false;

        gameAccountList.add(gameAccount);

        return true;
    }

    @PostMapping("/login")
    public LoginResponseForm gameAccountLogin (@RequestBody GameAccountForm gameAccountForm) {
        log.info("gameAccountLogin()");

        final Long LOGIN_FAILED_ACCOUND_ID = 0L;

        for (int i = 0; i < gameAccountList.size(); i++) {
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if (searchedGameAccountEmail.equals(gameAccountForm.getEmail())) {
                if (searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())) {
                    return new LoginResponseForm(true, searchedGameAccount.getId());
                }
                return new LoginResponseForm(false, LOGIN_FAILED_ACCOUND_ID);
            }
        }

        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUND_ID);
    }

    @PostMapping("/find-account-info")
    public String findAccountInfo (@RequestBody RequestAccountIdForm requestAccountIdForm) {
        final int LIST_BIAS = 1;
        log.info("findAccountInfo()");

        final GameAccount foundGameAccount = gameAccountList.get(
                (int) (requestAccountIdForm.getGameAccountId() - LIST_BIAS));

        return foundGameAccount.getEmail();
    }

    private boolean checkDuplicatedEmail(GameAccount gameAccount) {
        for (int i = 0; i < gameAccountList.size(); i++) {
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if (gameAccount.getEmail().equals(searchedGameAccountEmail)) {
                return true;
            }
        }
        return false;
    }
}
