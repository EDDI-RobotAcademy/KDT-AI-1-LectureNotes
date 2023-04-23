package com.example.demo.lectureClass.homework.bank4;

import com.example.demo.lectureClass.homework.bank4.account.Account;
import com.example.demo.lectureClass.homework.bank4.character.Character;
import com.example.demo.lectureClass.homework.bank4.enemy.Enemy;
import com.example.demo.lectureClass.homework.bank4.form.AccountSpecifyForm;
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
        currentAccount.getCharacterList().add(new Character(characterNum));

        CharacterStatusForm characterStatusForm = new CharacterStatusForm(
                currentAccount.getEmail(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getHealth(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getStrength(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getDexterity(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getIntelligence(),
                currentAccount.getCharacterList().get(characterNum - LIST_BIAS).getSkill()
        );

        log.info("info: " + characterStatusForm);
        return characterStatusForm;
    }


    @PostMapping("/bringEnemy")
    public List<Enemy> bringEnemyList (@RequestBody AccountSpecifyForm accountSpecifyForm) {
        final int LIST_BIAS = 1;
        Account currentAccount = accountList.get(accountSpecifyForm.getAccountId() -LIST_BIAS);
        currentAccount.addEnemy();
        return currentAccount.getEnemyList();
    }
}
