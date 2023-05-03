package com.example.demo.practice.gameCharacter;

import com.example.demo.practice.gameCharacter.accountInfo.GameAccount;
import com.example.demo.practice.gameCharacter.accountInfo.GameAccountForm;
import com.example.demo.practice.gameCharacter.accountInfo.RequestAccountIdForm;
import com.example.demo.practice.gameCharacter.logInInfo.LoginResponseForm;
import com.example.demo.practice.gameCharacter.statusInfo.CharacterModelForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/lets-show")
public class MakeGameAccount {
    private List<GameAccount> gameAccountList = new ArrayList<>();
    // 얘네 둘도 계속 변하는 애들이라서 final 박으면 안됨
    // 그리고 이 계정을 가지는 사람들이 showCharacterStatus() 에서 게임 플레이하기 때문에
    // 인스턴스 변수로 둘 것

    // TODO: 2023-04-20 지역변수에 뒀을 때 어떤 차이가 나타나는 지 알고 싶음
    // characterStatusList 얘 때문에 더더욱 인스턴스 변수로 두어야 하는 것인가?
    private static Long gameAccountId = 1L;
    // 얘는 지역에 둬도 된다고 생각.. 일단 둬보자
    // No. 캐릭터 계정을 생성할 때마다 계정 번호를 증가시키기 위해 사용하는 변수
    // 이 변수도 요청마다 새로운 값이 할당되어야 한다고 함
    // 지역 변수로 두면 매 요청마다 초기값인 1로 할당되기에 원하는 결과 얻을 수 없음

    private List<CharacterModelForm> characterStatusList = new ArrayList<>();

//    private Map<CharacterAccountForm, CharacterModelForm> characterStatusMap = new HashMap<>();

    // 어떻게 중복인지 판정할 것인가? - 이슈 발생
    Map<Long, GameAccount> selectAccountMap = new HashMap<>();

    @PostMapping("/character")
    public Boolean MakeGameAccount(@RequestBody GameAccountForm characterAccount) {
        // 이메일과 비밀번호를 받아와서 캐릭터 계정 생성
        log.info("accountInfo: " + characterAccount);
        // 캐릭터를 한 명만 받는 것이 아니기 때문에 계정리스트 추가해주기
        // -> Account 클래스 생성

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        // List를 HashMap으로 변환
        // 로그인 했을 때 이메일 주소 보여주고 계정선택
        final GameAccount gameAccount = characterAccount.toAccount(gameAccountId++);


        final CharacterModelForm characterModelForm = new CharacterModelForm(gameAccount.getId());
        characterStatusList.add(characterModelForm);
//        characterStatusMap.put(characterAccount,characterModelForm);

        gameAccountList.add(gameAccount);
        // Account 계정 객체 생성하여 accountList 생성
        // -> 계정 생성과 동시에 List에 추가할 수 있음
        // 매 요청마다 accountList를 새로 생성하는 것은 비효율적이므로,
        // 인스턴스 변수로 선언하는 것이 좋을 것
        // 인스턴스 변수로 선언하면 해당 객체 내에서 계속 유지되며, 여러 요청에서 공유 가능

        if (checkDuplicatedEmail(gameAccount)) {
            return false;
        } // Postman -> false: 사용할 수 있는 이메일이다

        gameAccountList.add(gameAccount);

        return true;
        // 이렇게 두면 입력한 정보들만 받아오게 되기 때문에 쌤이 한 방법대로 Boolean으로 해보자
    }

    @PostMapping("/character-status")
    @ResponseBody
    public CharacterModelForm getcharacterModelForm() { // 객체 생성을 안해줬으니까 메서드를 get으로 가져옴
        // 게임캐릭터 status 정보 넘기기
        log.info("Character status: " + characterStatusList.get(0));

//        return characterStatusList.get(0);
        // 캐릭터 상태 리스트의 첫 번째 값을 반환해라
        // 반환할 값이 뭐고 나타낼 값이 뭔지 충분히 인지하고 있어야 한다
        // Character status를 스프링에서 나타내고 싶었는데 나타내지 않는 상황이었음
        // log.info("Character status: "); 이렇게만 써놓은 상황이었음
        // 뭘 나타내려면 뭘 해야 하는지를 정확하게 파악하자

        return characterStatusList.get(0);
    }


    // 로그인 요청 수신 Controller
    @PostMapping("/login")
    // 수신한 Form의 password 검증하기
    public LoginResponseForm gameAccountLogin(@RequestBody GameAccountForm gameAccountForm) {
        log.info("gameAccountLogin: " + gameAccountForm);

        final Long LOGIN_FAILED_ACCOUNT_ID = 0L;

        // 자 이제 Vue에서 보낸 이메일의 중복 여부를 체크해볼꺼야
        // 먼저 리스트로 저장한 계정만큼 for 문을 돌리고
        // if 내가 보낸 비밀번호가 거기 있다면 중복체크를 해줄꺼야
        for (int i = 0; i < gameAccountList.size(); i++) {
            // 내가 찾는 계정의 이메일을 찾아줘야해
            // gameAccountList에 저장되어 있는 이메일을 가지고와서 찾아줘야함
            // 먼저 찾고 있는 이메일이 들어있는 계정을 찾아주자
            final GameAccount searchedGameAccount = gameAccountList.get(i);

            // 그리고 이제 searchedGameAccount의 이메일을 가지고 올꺼야
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            // 이제 if문으로 만약 작성한 이메일이 characterAccountForm에 있다면 true를 주고 없으면 false를 주자
            if (searchedGameAccountEmail.equals(gameAccountForm.getEmail())) {
                // if 내가 찾는 비밀번호가 characterAccountForm에 있다면 true를 주고 없으면 false를 주자
                if (searchedGameAccount.getPassword().equals(gameAccountForm.getPassword())) {
                    return new LoginResponseForm(true, searchedGameAccount.getId());
                    // 생성자 자체를 return할 수도 있구나
                    // 내가 찾는 비밀번호가 있다면 중복처리
                    // 찾고 있는 이메일을 리턴한다
                }
                return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
            }
        }

        return new LoginResponseForm(false, LOGIN_FAILED_ACCOUNT_ID);
    }

    // 수신한 form의 email 검증하기
    private boolean checkDuplicatedEmail(GameAccount gameAccount) {

        for (int i = 0; i < gameAccountList.size(); i++) {
            // 내가 찾는 계정
            final GameAccount searchedGameAccount = gameAccountList.get(i);
            // 내가 찾는 계정의 이메일은 내가 찾는 계정에서 이메일을 가져와서 저장해라
            final String searchedGameAccountEmail = searchedGameAccount.getEmail();

            // 어카운트 중에서 이메일이 내가 찾는 거면 true를 리턴해라
            if (gameAccount.equals(searchedGameAccountEmail)) {
                return true;
            }
        }
        return false;
    }

    @PostMapping("/find-account-info")
    public String findAccountInfo(@RequestBody RequestAccountIdForm requestAccountIdForm) {
        final int LIST_BIAS = 1;
        log.info("findAccountInfo: " + requestAccountIdForm);
        // PostMan으로 잘 받아오는 것 확인

        // 회원 고유의 Id 값으로 회원 찾기
        // GameAccount 클래스로 찾는 게임 계정을 변수로 만듬
        final GameAccount foundGameAccount = gameAccountList.get(
                (int)(requestAccountIdForm.getGameAccountId() - LIST_BIAS));
        // 거기에 requestAccountIdForm에서 게임 계정 아이디를 받아와서 1을 빼준 값을 게임계정목록에서 꺼내옴
        // GameAccount에 저장되는 Id를 리스트에 담아서 가져오는 것
        // 그래서 int로 정수형 변환해줌
        // 1을 빼주는 이유는 아이디는 1부터 시작하지만 리스트의 인덱스는 0부터 시작하기 때문
        // 아이디가 1인 계정은 게임계정 리스트의 0번째에 위치하는 것
        // 즉, 게임 계정 아이디를 요청하는 클래스에서 게임 계정 아이디를 받아와서
        // 1을 빼준 값이 게임계정 목록의 이메일 순서에 해당하는 것

        return foundGameAccount.getEmail();
        // 찾은 게임 계정(Id값)에서 이메일을 꺼내와라
        // Id값 치니 해당하는 이메일을 가져오긴 함
    }
}
