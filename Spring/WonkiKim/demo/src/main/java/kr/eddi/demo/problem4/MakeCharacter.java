package kr.eddi.demo.problem4;

import kr.eddi.demo.homework.homework418.FruitRequestForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("problem4")
public class MakeCharacter {
    CharacterResponseForm characterResponseForm;
    @PostMapping("make-character")
    @ResponseBody
    public CharacterResponseForm calculatePrice(@RequestBody IdRequestForm idRequestForm) {
        log.info(String.valueOf(idRequestForm));
        String email = idRequestForm.getEmail();
        String password = idRequestForm.getPassword();
        characterResponseForm = new CharacterResponseForm(email, password);
        return characterResponseForm;


    }
    @GetMapping("send-character")
    public CharacterResponseForm sendCharacter() {
        log.info(String.valueOf(characterResponseForm));
        return characterResponseForm;
    }
}
