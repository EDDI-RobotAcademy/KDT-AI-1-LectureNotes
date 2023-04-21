package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.account.Account;
import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import com.example.demo.lectureClass.homework.bank4.form.CharacterStatusForm;
import com.example.demo.lectureClass.homework.bank4.form.AccountCreationForm;
import com.example.demo.lectureClass.homework.bank4.form.LoginForm;
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
    List<Account> accountList = new ArrayList<>();
    GameManager gameManager;

    @PostMapping("/create")
    public boolean createAccount(@RequestBody AccountCreationForm accountCreationForm) {
        final Account account = accountCreationForm.toAccount(accountNumber);
        for (int i = 0; i < accountList.size(); i++) {
            final Account findAccount = accountList.get(i);
            if (account.getEmail().equals(findAccount.getEmail())) {
                return false;
            }
        }
        accountList.add(account);
        accountNumber++;
        return true;
    }

    @PostMapping("/login")
    public LoginForm loginResponse (@RequestBody AccountCreationForm accountCreationForm) {
        final Long failedLoginId = 0L;
        for (int i = 0; i < accountList.size(); i++) {
            final Account searchedAccount = accountList.get(i);

            if (searchedAccount.getEmail().equals(accountCreationForm.getEmail())) {
                if (searchedAccount.getPassword().equals(accountCreationForm.getPassword())) {
                    return new LoginForm(true, searchedAccount.getId());
                }
                return new LoginForm(false, failedLoginId);
            }
        } return new LoginForm(false, failedLoginId);
    }




    @GetMapping("/createCharacter")
    public CharacterStatusForm getCharacterStatus(@RequestParam ("accountId")long id) {
        int accountIdx = (int)id - 1;
        Account currentAccount = accountList.get(accountIdx);
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
