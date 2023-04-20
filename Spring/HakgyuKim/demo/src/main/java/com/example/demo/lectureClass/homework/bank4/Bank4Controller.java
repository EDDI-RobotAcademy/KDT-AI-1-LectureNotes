package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.account.Account;
import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import com.example.demo.lectureClass.homework.bank4.form.AccountCreationForm;
import com.example.demo.lectureClass.homework.bank4.form.CharacterStatusForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character-problem")
public class Bank4Controller {
    private static Long accountNumber = 1L;
    HashMap<Long, Account> accountMap = new HashMap<>();
    GameManager gameManager;

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountCreationForm accountCreationForm) {
        final Account account = accountCreationForm.toAccount(accountNumber);
        accountMap.put(accountNumber, account);
        accountNumber++;
    }

    @GetMapping("/getCharacterStatus")
    public CharacterStatusForm getCharacterStatus(@RequestParam ("accountId")int id) {
        Account currentAccount = accountMap.get(id);
        int characterNum = currentAccount.getCharacterList().size() + 1;
        currentAccount.getCharacterList().add(new Character("캐릭터" + characterNum, characterNum));

        CharacterStatusForm characterStatusForm = new CharacterStatusForm(
                currentAccount.getCharacterList().get(characterNum).getName(),
                currentAccount.getCharacterList().get(characterNum).getHealth(),
                currentAccount.getCharacterList().get(characterNum).getStrength(),
                currentAccount.getCharacterList().get(characterNum).getDexterity(),
                currentAccount.getCharacterList().get(characterNum).getIntelligence(),
                currentAccount.getCharacterList().get(characterNum).getSkill()
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
