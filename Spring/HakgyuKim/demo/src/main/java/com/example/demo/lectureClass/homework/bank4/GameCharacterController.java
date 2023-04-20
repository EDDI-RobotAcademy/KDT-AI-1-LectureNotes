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
    GameManager gameManager;

    @PostMapping("/makeCharacter")
    public void makeCharacter(@RequestBody CharacterMakeForm characterMakeForm) {
        log.info("data: " + characterMakeForm);
        gameManager = new GameManager(characterMakeForm.getEmail(),
                characterMakeForm.getPassword());
    }

    @GetMapping("/getCharacterStatus")
    public CharacterStatusForm getCharacterStatus() {
        CharacterStatusForm characterStatusForm = new CharacterStatusForm(
                gameManager.getCharacter().getEmail(),
                gameManager.getCharacter().getHealth(),
                gameManager.getCharacter().getStrength(),
                gameManager.getCharacter().getDexterity(),
                gameManager.getCharacter().getIntelligence(),
                gameManager.getCharacter().getSkill()
        );
        log.info("info: " + characterStatusForm);
        return characterStatusForm;
    }

    @GetMapping("/bringEnemy")
    public List<Enemy> bringEnemyList () {
        gameManager.addEnemy();
        System.out.println(gameManager.getEnemyList());
        return gameManager.getEnemyList();
    }
}
