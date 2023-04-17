package com.example.demo.lectureClass.game.controller;

import com.example.demo.lectureClass.game.GameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/dice-game")
public class GameController {


        @GetMapping("/play-game")
        public void playGame() {
            GameManager gameManager = new GameManager();
            gameManager.playGame();
            gameManager.printResult();
            gameManager.checkWinner();
        }
}