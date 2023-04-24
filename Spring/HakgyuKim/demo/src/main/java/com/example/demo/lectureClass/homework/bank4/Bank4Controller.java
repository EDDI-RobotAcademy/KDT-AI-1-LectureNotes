package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.account.Account;
import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import com.example.demo.lectureClass.homework.bank4.form.*;
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




    @PostMapping("/createCharacter")
    public CharacterStatusForm getCharacterStatus(@RequestBody AccountSpecifyForm accountSpecifyForm) {
        final int LIST_BIAS = 1;
        Account currentAccount = accountList.get(
                accountSpecifyForm.getAccountId() - LIST_BIAS);

        int characterNum = currentAccount.getCharacterList().size() + 1;
        currentAccount.getCharacterList().add(new Character(characterNum, "캐릭터" + characterNum));

        CharacterStatusForm characterStatusForm = new CharacterStatusForm(
                currentAccount.getEmail(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getCharacterName(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getHealth(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getStrength(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getDexterity(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getIntelligence(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getSkill(),
                characterNum
        );

        log.info("info: " + characterStatusForm);
        return characterStatusForm;
    }


    @PostMapping("/bringEnemy")
    public List<Enemy> bringEnemyList (@RequestBody AccountSpecifyForm accountSpecifyForm) {
        Account currentAccount = getAccount(accountSpecifyForm);
        currentAccount.addEnemy();
        return currentAccount.getEnemyList();
    }

    @PostMapping("/bringCharacterList")
    public List<Character> bringCharacterList (@RequestBody AccountSpecifyForm accountSpecifyForm) {
        Account currentAccount = getAccount(accountSpecifyForm);
        return currentAccount.getCharacterList();
    }

    @PostMapping("/getEnemyList")
    public List<Enemy> getEnemyList (@RequestBody AccountSpecifyForm accountSpecifyForm) {
        Account currentAccount = getAccount(accountSpecifyForm);
        return currentAccount.getEnemyList();
    }

    @PostMapping("/singleAtk")
    public List<Enemy> singleAtk (@RequestBody SingleAtkForm singleAtkForm) {
        final int LIST_BIAS = 1;
        Account currentAccount = accountList.get(singleAtkForm.getAccountId() -LIST_BIAS);
        Character currentCharacter = currentAccount.getCharacterList().get(singleAtkForm.getCharacterId() - LIST_BIAS);
        Enemy targetEnemy = currentAccount.getEnemyList().get(singleAtkForm.getTargetEnemyIdx());

        targetEnemy.setHealth(targetEnemy.getHealth() - currentCharacter.getSingleAtkDmg());
        log.info("singleAtkForm: " + singleAtkForm);
        log.info("dmg: " + currentCharacter.getSingleAtkDmg());
        return currentAccount.getEnemyList();
    }

    @PostMapping("/characterSelect")
    public Character characterSelect (@RequestBody CharacterSelectForm characterSelectForm) {
        final int LIST_BIAS = 1;
        Account currentAccount = accountList.get(characterSelectForm.getAccountId() - LIST_BIAS);
        return currentAccount.getCharacterList().get(characterSelectForm.getSelectedCharacterIdx());
    }


    private Account getAccount(AccountSpecifyForm accountSpecifyForm) {
        final int LIST_BIAS = 1;
        Account currentAccount = accountList.get(accountSpecifyForm.getAccountId() -LIST_BIAS);
        return currentAccount;
    }

}
