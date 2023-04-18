package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.untility.random.CustomRandom;
import com.example.demo.lectureClass.vue.homework.dicegame.game.GameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vue-homework")
public class VueHomework2Controller {
    // Vue 문제 은행 [ 2 ] 1번 문제
    @GetMapping("/get-random-dice-winner")
    public String getRandomDiceWin () {
        final int MIN = 1;
        final int MAX = 6;
        final String checkWin;

        int diceNumber = CustomRandom.generateNumber(MIN,MAX);
        if(diceNumber % 2 == 0){
            checkWin = "승리";
        } else {
            checkWin = "패배";
        }
        log.info("getRandomDiceWin() Request!" + diceNumber);
        return checkWin;
    }

    // Vue 문제 은행 [ 2 ] 2번 문제
    @GetMapping("/get-dice-game-manager")
    public String getDiceGameManager () {
        GameManager gameManager = new GameManager();
        System.out.println("After judging the score");

        gameManager.playGame();
        gameManager.printResult();
        gameManager.checkWinner();

        log.info("Winner of Dicegame is " + gameManager.checkWinner());
        return gameManager.checkWinner();
    }
}
