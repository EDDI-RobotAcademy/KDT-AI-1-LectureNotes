package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.dice.DiceGameManager;
import kr.eddi.demo.lectureClass.vue.problem.controller.form.MultiPlayerWinnerResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/dice-game")
public class VueProblem2Controller {
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