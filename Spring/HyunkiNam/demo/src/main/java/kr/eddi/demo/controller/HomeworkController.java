package kr.eddi.demo.controller;

import kr.eddi.demo.homework.GameManager;
import kr.eddi.demo.homework.Player;
import kr.eddi.demo.lectureClass.vue.controller.utility.random.CustomRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping("/win-condition-is-even")
    public StringBuilder winConditionIsEVEN(){
        final int MIN = 1;
        final int MAX = 6;
        final int EVEN_CHECK = 2;

        final int firstNumber = CustomRandom.generateNumber(MIN,MAX);
        final int secondNumber = CustomRandom.generateNumber(MIN,MAX);

        final int sum = firstNumber + secondNumber;

        StringBuilder sb = new StringBuilder();
        sb.append("첫번째 주사위: ").append(firstNumber)
                .append(" 두번째 주사위: ").append(secondNumber)
                .append(" 합 : ").append(sum);
        if(sum % EVEN_CHECK ==0){
            sb.append(" 승리");
            return sb;
        }
        sb.append(" 패배");
        return sb;
    }

    @GetMapping("/dice-game")
    public String diceGame(){
        GameManager gameManager = new GameManager();

        gameManager.playGame();

        return String.valueOf(gameManager.printPlayerList()) +" 승자 : "+ String.valueOf(gameManager.checking());
    }
}
