package kr.eddi.demo.lectureClass.vue.controller;

import kr.eddi.demo.lectureClass.diceRule.Dice;
import kr.eddi.demo.lectureClass.diceRule.GameManager;
import kr.eddi.demo.lectureClass.diceRule.player.Player;
import kr.eddi.demo.lectureClass.utility.random.CustomRandom;
import kr.eddi.demo.lectureClass.vue.controller.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {

    /*
    실제 @RequestMapping("/vue-test")와 @PostMapping("/receive-test")로 URL 경로가 만들어짐
    아래쪽에 있는 @RequestBody를 살펴봐야 합니다.
    객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
    또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송한 양식을 동일하게 유지하고 있어야 합니다.
    전송한 이름에 해당하는 studentName, studentAge 같은 정보가 정확하게 일치해야 합니다.
     */
    @PostMapping("/receive-test")
    public void receiveTest (@RequestBody VueRequestTestDataForm vueRequestTestDataForm) {
        log.info("received data: " + vueRequestTestDataForm);
    }

    @GetMapping("/get-random-dice")
    public Integer getRandomDice () {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumber(MIN, MAX);
    }

    @GetMapping("/get-random-dices")
    public List<Integer> getRandomDices () {
        final int MIN = 1;
        final int MAX = 6;
        int DICENUMBER = 2;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumberArr(MIN, MAX, DICENUMBER);
    }

    @GetMapping("/first-dice-check")
    public int getDiceNumber (List<Integer> myDiceArray) {
        final int MAX_DICE_NUM = 3;
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;
        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceNumberSum += myDiceArray.get(i);

            if (myDiceArray.get(FIRST_DICE_INFO) % DECISION_EVEN == ODD) {
                break;
            }
        }
        return diceNumberSum;
    }

    @GetMapping("/dice-rule")
    public List<Player> getGameManager () {
        GameManager gameManager = new GameManager();
        return gameManager.playGame();
    }

    @GetMapping("/get-hello")
    public String getHello() {
        return "Spring: 나도 안녕";
    }
}