package com.example.demo.lectureClass.homework.problem.problem2.controller;

import com.example.demo.lectureClass.homework.problem.problem2.dice.DiceGameManager;
import com.example.demo.lectureClass.homework.problem.problem2.form.WinnerResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
                diceGameManager.checkWinIfSumEven(tmpSum),
                tmpSum);

        log.info("responseForm: " + responseForm);
        return responseForm;
    }
}
