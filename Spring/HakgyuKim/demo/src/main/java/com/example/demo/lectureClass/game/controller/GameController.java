package com.example.demo.lectureClass.game.controller;

import com.example.demo.lectureClass.game.GameManager;
import com.example.demo.lectureClass.game.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/dice-game")
public class GameController {

        @GetMapping("/play-game")
        public List<Player> playGame() {
            GameManager gameManager = new GameManager();
            gameManager.playGame();
            return gameManager.getPlayerList();
        }


}