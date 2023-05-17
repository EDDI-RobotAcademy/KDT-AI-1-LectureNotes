package kr.eddi.demo.vue.problem.Controller;

import kr.eddi.demo.vue.problem.Controller.form.GameAccountForm;
import kr.eddi.demo.vue.problem.Controller.form.LoginResponseForm;
import kr.eddi.demo.vue.problem.Controller.form.RequestAccountIdForm;
import kr.eddi.demo.vue.problem.entity.GameAccount;
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
    // 어카운트 리스트 생성
    private static Long gameAccountId = 1L;
    // 초기 어카운트 id는 1L로 시작함
    @PostMapping("/create")
    public Boolean createGameAccount (@RequestBody GameAccountForm gameAccountForm) {
        log.info("createGameAccount()");
        // 아이디 생성한는 부분 어카운트 폼으로 이메일과 패스워드 받음
        final GameAccount gameAccount = gameAccountForm.toGameAccount(gameAccountId++);
        // 매서드로 어카운트 생성하고 후위 연산으로 id 1증가 시킴
        if (checkDuplicatedEmail(gameAccount)){
            return false;
        }
        // 값이 거짓이어야 중복이 아니기 때문에 아이디가 생성된다.


        gameAccountList.add(gameAccount);
        //아이디 리스트에 추가한다.
        // 리턴 true
        return true;
    }

    @PostMapping("/login")// 로그인이 가능한지 아닌지에 대한 매서드
    public LoginResponseForm gameAccountLogin (@RequestBody GameAccountForm gameAccountForm) {
        log.info("gameAccountLogin()");
        // 이메일과 패스워드를 전달 받는다.
        final Long LOGIN_FAILED_ACCOUND_ID = 0L;
        //로그인 실패 경우의 아이디 는 0으로 설정
        for (int i = 0; i < gameAccountList.size(); i++) {
            // 현재 어카운트 리스트의 길이만큼 진행합니다.
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            // 리스트에 어카운트 객체 하나씩 가져옴
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();
            // 어카운트에서 이메일 하나씩 빼옵니다.
            if (searchedGameAccountEmail.equals(gameAccountForm.getEmail())) {
                //만약에 받아온 아이디가 위에 뷰에서 넘어온 아이디와 같다면 아래 진행함
                if (searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())) {
                    // 받아온 패스워드 또한 뷰에서 넘겨받은 것과 같다면 아래 진행함
                    return new LoginResponseForm(true, searchedGameAccount.getId());
                    //둘다 같으면 로그인 가능을 리턴하고 그 아이디 리턴합니다.
                }
                return new LoginResponseForm(false, LOGIN_FAILED_ACCOUND_ID);
                //비번 틀리면 false 리턴 하고 0 을 리턴함
            }
        }

        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUND_ID);
        //여기는 id 틀렸을 경우 거짓 리턴함
    }

    @PostMapping("/find-account-info")
    public String findAccountInfo (@RequestBody RequestAccountIdForm requestAccountIdForm) {
        // 뷰에서 로컬 스토리지의 아이디를 보냅니다.
        final int LIST_BIAS = 1;
        //빼야할 값 1
        log.info("findAccountInfo()");
        //1부터 시작하지만 idx는 0부터 이기 때문에 1을 마이너스함.
        final GameAccount foundGameAccount = gameAccountList.get(
            //리스트에서 아이디 값으로 어카운트 찾아옴
                (int) (requestAccountIdForm.getGameAccountId() - LIST_BIAS));
        //찾아온 어카운트 리턴합니다.
        return foundGameAccount.getEmail();
    }
    //중복 체크를 하기 위한 것임
    private boolean checkDuplicatedEmail(GameAccount gameAccount) {
        //리스트의 어카운트 갯수 만큼 반복한다.
        //없으면 거짓을 리턴함
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