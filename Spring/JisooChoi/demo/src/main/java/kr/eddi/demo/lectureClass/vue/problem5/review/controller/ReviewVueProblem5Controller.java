package kr.eddi.demo.lectureClass.vue.problem5.review.controller;

import kr.eddi.demo.lectureClass.vue.problem5.review.controller.form.GameAccountForm;
import kr.eddi.demo.lectureClass.vue.problem5.review.controller.form.LoginResponseForm;
import kr.eddi.demo.lectureClass.vue.problem5.review.controller.form.RequestAccountIdForm;
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

    // 계정을 저장하는 리스트
    private final List<GameAccount> gameAccountList = new ArrayList<>();
    private static Long gameAccountId = 1L;

    // 1. 계정 생성 (gameAccountList에 추가하는 작업)
    @PostMapping("/create")
    public Boolean createGameAccount (@RequestBody GameAccountForm gameAccountForm) {
        log.info("createGameAccount()");

        // account, id, pw를 객체로 만들어서 저장
        final GameAccount gameAccount = gameAccountForm.toGameAccount(gameAccountId++);

        if (checkDuplicatedEmail(gameAccount))
            return false;
        // 중복된 Email 이 없다면 아래를 진행

        // 리스트에 계정 정보를 추가해준다. (저장)
        gameAccountList.add(gameAccount);

        return true;
    }

    // 2. 로그인 요청에 대한 사용자 검증 과정
    @PostMapping("/login")
    public LoginResponseForm gameAccountLogin (@RequestBody GameAccountForm gameAccountForm) {
        log.info("gameAccountLogin()");

        final Long LOGIN_FAILED_ACCOUNT_ID = 0L;

        for (int i = 0; i < gameAccountList.size(); i++) {
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            if (searchedGameAccountEmail.equals(gameAccountForm.getEmail())) {
                // 이메일이 같다면 비밀번호도 같은 지 확인하기
                if (searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())) {
                    // 같다면, 계정이 존재하므로 로그인 완료 !

                    // 여기서 Id는 숫자 값인데, 각 계정이 생성되면 리스트에 들어가게 되고
                    // 리스트의 순서 항목을 뜻 한다고 생각하면 된다.
                    return new LoginResponseForm(true, searchedGameAccount.getId());
                }
                // 다르다면, 계정이 존재하지 않으므로 로그인 실패 !
                return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
            }
        }

        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
    }

    // 3. 로그인한 사용자의 정보를 찾아서 보내준다.
    @PostMapping("/find-account-info")
    public String findAccountInfo (@RequestBody RequestAccountIdForm requestAccountIdForm) {
        final int LIST_BIAS = 1;
        log.info("findAccountInfo()");

        final GameAccount foundGameAccount = gameAccountList.get(
                (int) (requestAccountIdForm.getGameAccountId() - LIST_BIAS)); // ★ 자꾸 에러나는 부분

        return foundGameAccount.getEmail();
    }

    // email 중복 여부 검사
    private boolean checkDuplicatedEmail(GameAccount gameAccount) {
        for (int i = 0; i < gameAccountList.size(); i++) {
            // 새로운 객체에 리스트에 현재 존재하는 정보를 넣어준다.
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            // 정보를 가진 객체의 아이디를 넣어준다.
            // Email 값 하나를 비교해야 하니까 String 값으로 바꾸어 준 것임
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            // 현재 비교하고 싶은 이메일 값과 기존에 들어있던 이메일을 비교한다.
            //   gameAccount.getEmail     searchedGameAccountEmail
            if (gameAccount.getEmail().equals(searchedGameAccountEmail)) {
                return true;
            }
        }
        return false;
    }
}
