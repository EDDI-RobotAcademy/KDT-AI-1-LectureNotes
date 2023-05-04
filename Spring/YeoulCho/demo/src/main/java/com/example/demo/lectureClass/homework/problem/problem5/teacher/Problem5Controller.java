package com.example.demo.lectureClass.homework.problem.problem5.teacher;


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
public class Problem5Controller {
    private final List<GameAccount> gameAccountList = new ArrayList<>();
    private static long gameAccountId = 1;
    @PostMapping("/create")
    public boolean createGameAccount(@RequestBody GameAccountForm gameAccountForm){
        log.info("createGameAccount()");
        final GameAccount gameAccount = gameAccountForm.toGameAccount(gameAccountId++);
        if(checkDuplicatedEmail(gameAccount)){ //일치하는게 없어야 false, 그러면 if문이 안가니까 gameAccountList에 추가하고 true 반환
            return false;} //1줄일때 {}생략가능
        gameAccountList.add(gameAccount);
        log.info(gameAccountList.toString());
        return true;
    }

    public boolean checkDuplicatedEmail(GameAccount gameAccount){
        for(int i =0; i<gameAccountList.size();i++){
            final GameAccount searchedGameAccount= gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

        if(gameAccount.getEmail().equals(searchedGameAccountEmail)){
            return true; // for문 도는 동안 일치하는게 있다면 여기서 걸려서 true로 나감
        }
        } return false; //이메일이 일치하는게 없으면 false를 내보냄
        }
    @PostMapping("/login")
    public LoginResponseForm gameAccountLogin(@RequestBody GameAccountForm gameAccountForm){
        //GameAccountForm형태로 vue에서 데이터 받음
        log.info("gameAccountLogin()");
        log.info(String.valueOf(gameAccountForm));
        log.info(String.valueOf(gameAccountList));
        final long LOGIN_FAILED_ACCOUND_ID = 0;

        for (int i = 0; i < gameAccountList.size(); i++) {
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if (searchedGameAccountEmail.equals(gameAccountForm.getEmail())) {
                log.info(searchedGameAccountEmail);
                log.info(gameAccountForm.getEmail());
                if (searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())) {

                    log.info(String.valueOf(searchedGameAccount.getId()));
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
}
