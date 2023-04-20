package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import com.example.demo.lectureClass.homework.bank4.form.CharacterMakeForm;
import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.form.CharacterStatusForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character-problem")
public class GameCharacterController {
    List<Enemy> enemyList;
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

    @GetMapping("/bringEnemy")
    public List<Enemy> bringEnemyList () {
        final int EnemyCount = 3;
        enemyList = new ArrayList<>();

        for(int i = 0; i < EnemyCount; i++) {
            enemyList.add(new Enemy());
        }
        return enemyList;
    }
}
