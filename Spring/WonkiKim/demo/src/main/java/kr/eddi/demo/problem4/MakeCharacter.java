package kr.eddi.demo.problem4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("problem4")
public class MakeCharacter {
    Map<Integer, Account> accountMap= new HashMap<>();
    @PostMapping("make-character")
    @ResponseBody
    public CharacterResponseForm calculatePrice(@RequestBody AccountRequestForm accountRequestForm) {
        log.info(String.valueOf(accountRequestForm));

        String email = accountRequestForm.getEmail();
        String password = accountRequestForm.getPassword();

        Account account = new Account(email, password);
        accountMap.put(account.getId(), account);
        log.info(String.valueOf(account.getId()));
        log.info(String.valueOf(account.getCharacter()));
        return new CharacterResponseForm(account.getId(), account.getCharacter());
    }

    @PostMapping("log-in")
    @ResponseBody
    public CharacterResponseForm calculatePrice(@RequestBody AccountRequestForm accountRequestForm) {
        log.info("로그인 시도");
        log.info(String.valueOf(accountRequestForm));

        if(accountMap.containsKey())
    }
}
