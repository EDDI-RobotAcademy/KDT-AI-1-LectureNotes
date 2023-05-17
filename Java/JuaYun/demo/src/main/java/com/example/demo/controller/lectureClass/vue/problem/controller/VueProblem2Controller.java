package com.example.demo.controller.lectureClass.vue.problem.controller;

import com.example.demo.controller.lectureClass.vue.problem.controller.form.MultiPlayerWinnerResponseForm;
import com.example.demo.controller.lectureClass.vue.problem.controller.form.WinnerResponseForm;
import com.example.demo.controller.lectureClass.vue.problem.dice.Dice;
import com.example.demo.controller.lectureClass.vue.problem.dice.DiceGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.MenuBarUI;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class VueProblem2Controller {

    /*
   랜덤한 주사위 2개를 돌립니다.
   돌린 주사위의 값의 합이 짝수라면 승리를 반환하고 홀수라면 패배를 반환합니다.
    */
    @GetMapping("/firstGame")
    public WinnerResponseForm doFirstDiceGame () {
        log.info("firstGame()");

        final int DICE_NUM = 2;

        DiceGameManager diceGameManager = new DiceGameManager(DICE_NUM);
        log.info("diceGameManager: " + diceGameManager);

        int tmpSum = diceGameManager.calculatePlayerDiceSum();
        WinnerResponseForm responseForm = new WinnerResponseForm(
                tmpSum,
                diceGameManager.checkWinIfSumEven(tmpSum));

        log.info("responseForm: " + responseForm);
        return responseForm;
    }

    @GetMapping("/secondGame")
    public MultiPlayerWinnerResponseForm doSecondGame () {
        log.info("secondGame()");

        final int DICE_NUM = 3;
        final int PLAYER_NUM = 2;

        DiceGameManager diceGameManager = new DiceGameManager(PLAYER_NUM, DICE_NUM);
        log.info("diceGameManager: " + diceGameManager);

        diceGameManager.applyCondition();
        log.info("after condition process - diceGameManager: " + diceGameManager);

        MultiPlayerWinnerResponseForm multiPlayerWinnerResponseForm = new MultiPlayerWinnerResponseForm(diceGameManager.checkWinner(), diceGameManager.getPlayerList());

        return multiPlayerWinnerResponseForm;
    }
}
// 오류가 발생하면 f12를 누르고 소스로 들어가 확인해본다.
