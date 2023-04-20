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
    Map<Integer, Character> characterMap = new HashMap<>();
    @PostMapping("make-character")
    @ResponseBody
    public CharacterResponseForm calculatePrice(@RequestBody AccountRequestForm accountRequestForm) {
        log.info(String.valueOf(accountRequestForm));

        String email = accountRequestForm.getEmail();
        String password = accountRequestForm.getPassword();

        Account account = new Account(email, password);
        Character character = new Character(account.getId());

        accountMap.put(account.getId(), account);
        characterMap.put(account.getId(), character);

        log.info(String.valueOf(account.getId()));
        log.info(String.valueOf(character));
        return new CharacterResponseForm(character);
    }

    @PostMapping("log-in")
    @ResponseBody
    public LoginResponseForm logIn(@RequestBody LoginRequestForm loginRequestForm) {
        log.info("Try to sign in");
        log.info(String.valueOf(loginRequestForm));

        int id = loginRequestForm.getId();

        final int SUCCESS = 0;
        final int WRONG_PASSWORD = 1;
        final int WRONG_ID = 2;
        if(accountMap.containsKey(id)) {


            if(accountMap.get(id).getPassword().equals(loginRequestForm.getPassword())) {
                log.info("Successful login");

                String email = accountMap.get(id).getEmail();
                Character character = characterMap.get(id);
                LoginResponseForm loginResponseForm = new LoginResponseForm(email, character, SUCCESS);
                return loginResponseForm;
            } else{
                log.info("wrong password");
                return new LoginResponseForm(null, null, WRONG_PASSWORD);
            }
        } else {
            log.info("wrong id or password");
            return new LoginResponseForm(null, null, WRONG_ID);

        }
    }
}
