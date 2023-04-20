package com.example.demo.practice.gameCharacter;

import com.example.demo.practice.gameCharacter.accountInfo.Account;
import com.example.demo.practice.gameCharacter.accountInfo.CharacterAccountForm;
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
//    private List<Account> accountList = new ArrayList<>();
    private Map<Long, Account> accountMap = new HashMap<>();
    // 얘네 둘도 계속 변하는 애들이라서 final 박으면 안됨
    // 그리고 이 계정을 가지는 사람들이 showCharacterStatus() 에서 게임 플레이하기 때문에
    // 인스턴스 변수로 둘 것

    // TODO: 2023-04-20 지역변수에 뒀을 때 어떤 차이가 나타나는 지 알고 싶음
    // characterStatusList 얘 때문에 더더욱 인스턴스 변수로 두어야 하는 것인가?
    private Long accountNumber = 1L;
    // 얘는 지역에 둬도 된다고 생각.. 일단 둬보자
    // No. 캐릭터 계정을 생성할 때마다 계정 번호를 증가시키기 위해 사용하는 변수
    // 이 변수도 요청마다 새로운 값이 할당되어야 한다고 함
    // 지역 변수로 두면 매 요청마다 초기값인 1로 할당되기에 원하는 결과 얻을 수 없음

//    private List<CharacterModelForm> characterStatusList = new ArrayList<>();

    private Map<Long, CharacterModelForm> chooseAccountMap = new HashMap<>();

    @PostMapping("/character")
    public Boolean MakeGameAccount(@RequestBody CharacterAccountForm characterAccount) {
        // 이메일과 비밀번호를 받아와서 캐릭터 계정 생성
        log.info("accountInfo: " + characterAccount);
        // 캐릭터를 한 명만 받는 것이 아니기 때문에 계정리스트 추가해주기
        // -> Account 클래스 생성

        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        // List를 HashMap으로 변환
        // 로그인 했을 때 이메일 주소 보여주고 계정선택
        final Account account = characterAccount.toAccount(accountNumber);
        accountNumber++;

        accountMap.put(account.getId(), account);
//        accountList.add(account);
        // Account 계정 객체 생성하여 accountList 생성
        // -> 계정 생성과 동시에 List에 추가할 수 있음
        // 매 요청마다 accountList를 새로 생성하는 것은 비효율적이므로,
        // 인스턴스 변수로 선언하는 것이 좋을 것
        // 인스턴스 변수로 선언하면 해당 객체 내에서 계속 유지되며, 여러 요청에서 공유 가능

        final CharacterModelForm characterModelForm = new CharacterModelForm(account.getId());
//        characterStatusList.add(characterModelForm);
        chooseAccountMap.put(account.getId(),characterModelForm);

        return true;
        // 이렇게 두면 입력한 정보들만 받아오게 되기 때문에 쌤이 한 방법대로 Boolean으로 해보자
    }

    @PostMapping("/character-status")
    @ResponseBody
    public CharacterModelForm getcharacterModelForm() { // 객체 생성을 안해줬으니까 메서드를 get으로 가져옴
        // 게임캐릭터 status 정보 넘기기
        log.info("Character status: " + chooseAccountMap.get(accountNumber));

//        return characterStatusList.get(0);
        // 캐릭터 상태 리스트의 첫 번째 값을 반환해라
        // 반환할 값이 뭐고 나타낼 값이 뭔지 충분히 인지하고 있어야 한다
        // Character status를 스프링에서 나타내고 싶었는데 나타내지 않는 상황이었음
        // log.info("Character status: "); 이렇게만 써놓은 상황이었음
        // 뭘 나타내려면 뭘 해야 하는지를 정확하게 파악하자

        return chooseAccountMap.get(accountNumber);
    }
}
