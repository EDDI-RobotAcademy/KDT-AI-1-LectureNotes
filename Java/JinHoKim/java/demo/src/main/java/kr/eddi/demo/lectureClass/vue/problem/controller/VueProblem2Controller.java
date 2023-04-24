package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.WinnerResponseForm;
import kr.eddi.demo.lectureClass.vue.problem.dice.DiceGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class VueProblem2Controller {

    @GetMapping("/firstGame")
    public WinnerResponseForm doFirstDiceGame() {
        log.info("firstGame()");

        final int DICE_NUM = 2;

        DiceGameManager diceGameManager = new DiceGameManager(DICE_NUM);
        log.info("diceGameManager: " + diceGameManager);

        int tmpSum = diceGameManager.calculatePlayerDiceSum();
        WinnerResponseForm responseForm = new WinnerResponseForm(tmpSum, diceGameManager.checkWinIfSumEven(tmpSum));

        log.info("responseForm: " + responseForm);
        return responseForm;
    }
}
