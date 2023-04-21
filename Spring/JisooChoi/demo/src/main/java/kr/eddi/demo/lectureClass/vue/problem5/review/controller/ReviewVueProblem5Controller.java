package kr.eddi.demo.lectureClass.vue.problem5.review.controller;

import kr.eddi.demo.lectureClass.vue.problem5.review.controller.form.GameAccountForm;
import kr.eddi.demo.lectureClass.vue.problem5.review.controller.form.LoginResponseForm;
import kr.eddi.demo.lectureClass.vue.problem5.review.entity.GameAccount;
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
public class ReviewVueProblem5Controller {

    // 어떻게 중복인지 판정할 것인가 ?
    private final List<GameAccount> gameAccountList = new ArrayList<>();
    private static Long gameAccountId = 1L;

    @PostMapping("/create")
    public Boolean createGameAccount (@RequestBody GameAccountForm gameAccountForm){
        log.info("createGameAccount()");
        
        final GameAccount gameAccount = gameAccountForm.toAccount(gameAccountId++);
        
        if(isCheckDuplicatedEmail(gameAccount))
            return false;

        gameAccountList.add(gameAccount);

        return true;
    }

    @PostMapping("/login")
    public LoginResponseForm gameAccountLogin (@RequestBody GameAccountForm gameAccountForm){
        log.info("gameAccountLogin()");

        final Long LOGIN_FAILED_ACCOUNT_ID = 0L;

        for(int i = 0; i< gameAccountList.size(); i++){
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if(searchedGameAccountEmail.equals(gameAccountForm.getEmail())){
                if(searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())){
                    return new LoginResponseForm(true, searchedGameAccount.getId());
                }
                return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
            }
        }

        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
    }

    private boolean isCheckDuplicatedEmail(GameAccount gameAccount) {
        for(int i = 0; i< gameAccountList.size(); i++){
            final GameAccount searchGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchGameAccount.getEmail();

            if(gameAccount.getEmail().equals(searchedGameAccountEmail)){
                return true;
            }
        }

        return false;
    }


}
