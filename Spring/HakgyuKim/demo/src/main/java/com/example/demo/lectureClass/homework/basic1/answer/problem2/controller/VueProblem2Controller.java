package com.example.demo.lectureClass.homework.basic1.answer.problem2.controller;

import com.example.demo.lectureClass.homework.basic1.answer.problem2.controller.form.MultiPlayerWinnerResponseForm;
import com.example.demo.lectureClass.homework.basic1.answer.problem2.controller.form.WinnerResponseForm;
import com.example.demo.lectureClass.homework.basic1.answer.problem2.dice.DiceGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-problem")
public class VueProblem2Controller {

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

        return responseForm;
    }

    @GetMapping("/secondGame")
    public MultiPlayerWinnerResponseForm doSecondGame () {
        log.info("secondGame()");

        final int DICE_NUM = 3;
        final int PLAYER_NUM = 2;

        DiceGameManager diceGameManager = new DiceGameManager(PLAYER_NUM, DICE_NUM);
        log.info("diceGameManager:" + diceGameManager);

        diceGameManager.applyCondition();
        log.info("after condition process : " + diceGameManager);

        MultiPlayerWinnerResponseForm multiPlayerWinnerResponseForm = new MultiPlayerWinnerResponseForm(
                diceGameManager.checkWinner(),
                diceGameManager.getPlayerList()
        );


        return multiPlayerWinnerResponseForm;
    }
}
