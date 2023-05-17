package kr.eddi.demo.vue.problem.Controller;

import kr.eddi.demo.vue.problem.Controller.form.AccountCreationForm;
import kr.eddi.demo.vue.problem.entity.Account;
import kr.eddi.demo.vue.problem.entity.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("/test-account")
public class VueProblem4Controller {
    // 계정 넘버 우선 1번으로 함
    // 식별 넘버는 Long을 관습적으로 사용한다.
    private static Long accountNumber = 1L;
    private static List<Account> accountList = new ArrayList<>();
    private static List<CharacterStatus> characterStatusList = new ArrayList<>();

    HashMap<Objects,CharacterStatus> characterStatusHashMap =new HashMap<>();

    @PostMapping("/create")
    public Boolean createAccount (@RequestBody AccountCreationForm accountCreationForm) {
        log.info("createAccount(): " + accountCreationForm);
        // 리스트는 트리 기반의 검색을 합니다.
        // 반면 해쉬는 키를 던지면 값을 즉각 반환합니다.
        final Account account = accountCreationForm.toAccount(accountNumber);
        //1L을 넣어서 폼에서 account를 생성해준다.
        accountNumber++;
        //그후 1 상승

        accountList.add(account);
        //생성된 어카운트를 list에 넣어준다.
        final CharacterStatus characterStatus = new CharacterStatus(account.getId());
        //어카운트의 id를 getId를 통해 가져와서 랜덤 스테이터스 생성한다.
        characterStatusList.add(characterStatus);
        // 스테이터스 리스트에 랜덤 스테이터스 생성해줌

        // 트루가 리턴됨
        return true;
    }

    @GetMapping("/get-status")
    public CharacterStatus getCharacterStatus () {
        log.info("getCharacterStatus()");
//  스테이터스 형식으로 가져온다.
        // 처음 만든 스테이터스 보내줌
        return characterStatusList.get(0);
    }
}