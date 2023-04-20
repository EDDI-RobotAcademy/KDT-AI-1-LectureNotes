package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.account.Account;
import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import com.example.demo.lectureClass.homework.bank4.form.AccountCreationForm;
import com.example.demo.lectureClass.homework.bank4.form.CharacterStatusForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character-problem")
public class Bank4Controller {
    private static Long accountNumber = 1L;
    private static List<Account> accountList = new ArrayList<>();
    GameManager gameManager;

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountCreationForm accountCreationForm) {
        final Account account = accountCreationForm.toAccount(accountNumber);
        accountNumber++;
        accountList.add(account);

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
