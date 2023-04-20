package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.form.CharacterMakeForm;
import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.form.CharacterStatusForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/character-problem")
public class GameCharacterController {
    Character character;

    @PostMapping("/makeCharacter")
    public void makeCharacter(@RequestBody CharacterMakeForm characterMakeForm) {
        log.info("data: " + characterMakeForm);
        character = new Character(characterMakeForm.getEmail(),
                characterMakeForm.getPassword());
    }

    @GetMapping("/getCharacterStatus")
    public CharacterStatusForm getCharacterStatus() {
        CharacterStatusForm characterStatusForm = new CharacterStatusForm(
                character.getHealth(),
                character.getStrength(),
                character.getDexterity(),
                character.getIntelligence(),
                character.getSkill()
        );
        log.info("info: " + character);
        log.info("info: " + characterStatusForm);
        return characterStatusForm;
    }
}
