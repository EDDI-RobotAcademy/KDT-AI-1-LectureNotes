package com.example.demo.lectureClass.vue.controller;

import com.example.demo.lectureClass.dicegame.game.GameManager;
import com.example.demo.lectureClass.untility.random.CustomRandom;
import com.example.demo.lectureClass.vue.controller.form.VueRequestTestDataForm;
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
    아래 쪽에 있는 @RequestBody를 살펴봐야 합니다.
    객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
    또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송된 양식을 통일하게 유지하고 있어야 합니다.
    전송한 이름에 해당하는 studentName, studentMajor, studentAge 같은 정보가 정확하게 일치해야 합니다.
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

        return CustomRandom.generateNumber(MIN,MAX);
    }
    @GetMapping("/get-random-dice-winner")
    public String getRandomDiceWin () {
        final int MIN = 1;
        final int MAX = 6;
        String checkWin;

        int diceNumber = CustomRandom.generateNumber(MIN,MAX);
        if(diceNumber % 2 == 0){
            checkWin = "승리";
        } else {
            checkWin = "패배";
        }
        log.info("getRandomDiceWin() 요청!" + diceNumber);
        return checkWin;
    }
    @GetMapping("/get-random-dice-list")
    public int getRandomDiceList () {
        final int DICENUM = 3;

        int diceNumberSum = 0;

        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        List<Integer> diceList = new ArrayList<>();

        for(int i = 0; i < DICENUM; i++){
            int diceNumber = getRandomDice();
            diceList.add(diceNumber);

            diceNumberSum += diceList.get(i);

            if(diceList.get(FIRST_DICE_INFO) % DECISION_EVEN == ODD){
                break;
            }
        }
        log.info("getRandomDiceList() 요청!" + diceList);
        return diceNumberSum;
    }
    @GetMapping("/get-dice-game-manager")
    public String getDiceGameManager () {
        GameManager gameManager = new GameManager();
        System.out.println("점수 판정 이후");
        gameManager.playGame();
        gameManager.printResult();
        gameManager.checkWinner();
        log.info("dicegame winner is " + gameManager.checkWinner());
        // return gameManager.toString();
        return gameManager.checkWinner();
    }
}
