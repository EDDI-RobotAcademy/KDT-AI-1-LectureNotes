package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.MultiPlayerWinnerResponseForm;
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

        MultiPlayerWinnerResponseForm multiPlayerWinnerResponseForm = new MultiPlayerWinnerResponseForm(
                diceGameManager.checkWinner(),
                diceGameManager.getPlayerList()
        );

        return multiPlayerWinnerResponseForm;
    }
}
