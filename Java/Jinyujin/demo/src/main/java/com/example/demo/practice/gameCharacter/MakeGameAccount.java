package com.example.demo.practice.gameCharacter;

import com.example.demo.practice.gameCharacter.accountInfo.Account;
import com.example.demo.practice.gameCharacter.accountInfo.CharacterAccountForm;
import com.example.demo.practice.gameCharacter.statusInfo.CharacterModelForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lets-show")
public class MakeGameAccount {
    private List<Account> accountList = new ArrayList<>();
    // 얘네 둘도 계속 변하는 애들이라서 final 박으면 안됨
    // 그리고 이 계정을 가지는 사람들이 showCharacterStatus() 에서 게임 플레이하기 때문에
    // 인스턴스 변수로 둘 것

    private Long accountNumber = 1L;
    // 얘는 지역에 둬도 된다고 생각.. 일단 둬보자
    // No. 캐릭터 계정을 생성할 때마다 계정 번호를 증가시키기 위해 사용하는 변수
    // 이 변수도 요청마다 새로운 값이 할당되어야 한다고 함
    // 지역 변수로 두면 매 요청마다 초기값인 1로 할당되기에 원하는 결과 얻을 수 없음

    private List<CharacterModelForm> characterStatusList = new ArrayList<>();

    @PostMapping("/character")
    public Boolean MakeGameAccount(@RequestBody CharacterAccountForm characterAccount) {
        // 이메일과 비밀번호를 받아와서 캐릭터 계정 생성
        log.info("accountInfo: " + characterAccount);
        // 캐릭터를 한 명만 받는 것이 아니기 때문에 계정리스트 추가해주기
        // -> Account 클래스 생성

        final Account account = characterAccount.toAccount(accountNumber);
        accountNumber++;

        accountList.add(account);
        // Account 계정 객체 생성하여 accountList 생성
        // -> 계정 생성과 동시에 List에 추가할 수 있음
        // 매 요청마다 accountList를 새로 생성하는 것은 비효율적이므로,
        // 인스턴스 변수로 선언하는 것이 좋을 것
        // 인스턴스 변수로 선언하면 해당 객체 내에서 계속 유지되며, 여러 요청에서 공유 가능

        final CharacterModelForm characterModelForm = new CharacterModelForm(account.getId());
        characterStatusList.add(characterModelForm);

        return true;
        // 이렇게 두면 입력한 정보들만 받아오게 되기 때문에 쌤이 한 방법대로 Boolean으로 해보자
    }

    @PostMapping("/character-status")
    @ResponseBody
    public CharacterModelForm getcharacterModelForm() { // 객체 생성을 안해줬으니까 메서드를 get으로 가져옴
        // 게임캐릭터 status 정보 넘기기
        log.info("Character status: " + characterStatusList.get(0));

        return characterStatusList.get(0);
        // 캐릭터 상태 리스트의 첫 번째 값을 반환해라
        // 반환할 값이 뭐고 나타낼 값이 뭔지 충분히 인지하고 있어야 한다
        // Character status를 스프링에서 나타내고 싶었는데 나타내지 않는 상황이었음
        // log.info("Character status: "); 이렇게만 써놓은 상황이었음
        // 뭘 나타내려면 뭘 해야 하는지를 정확하게 파악하자
    }
}
