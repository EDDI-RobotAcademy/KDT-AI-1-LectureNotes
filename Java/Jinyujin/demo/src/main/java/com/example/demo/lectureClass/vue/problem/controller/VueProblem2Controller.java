package com.example.demo.lectureClass.vue.problem.controller;

import com.example.demo.lectureClass.vue.problem.controller.form.WinnerResponseForm;
import com.example.demo.lectureClass.vue.problem.dice.DiceGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")

// 여기서 데이터를 보내는 것!!!
public class VueProblem2Controller {
    /*
    랜덤한 주사위 2개를 돌립니다.
    돌린 주사위의 값의 합이 짝수라면 승리를 반환하고 홀수라면 패배를 반환합니다.
    */
    @GetMapping("/firstGame")
    public WinnerResponseForm VueProblem2Controller() {
        log.info("firstGame()");
        // log.info()는 메서드의 실행 정보를 로그에 남기는 코드
        // 이를 사용하여 메서드가 실행된 시간, 실행된 클래스, 매서드의 이름 등의
        // 정보에 대한 로그를 남길 수 있음

        // 매개변수 diceMaxNumber에 넣을 값(주사위 개수)에 대한 변수 선언
        final int DICE_NUM = 2;

        // 먼저 DiceGameManager 클래스를 가져와서 그 정보를 써먹을 것
        DiceGameManager diceGameManager = new DiceGameManager(DICE_NUM);
        log.info("diceGameManager: " + diceGameManager);

        // 이제 이겼는지 졌는지 판단하기 위해 체크윈 메서드 생성
        // 그 과정에서 플레이어의 주사위 합산 값을 구하는 메서드 생성
        int tmpSum = diceGameManager.calculatePlayerDiceSum();

//        return diceGameManager.checkWinIfSumEven(tmpSum);
        // 여기까지 실행했을 때 승패의 결과는 잘 나옴
        // 근데 부족한 점: 몇 점을 받았는데? -> form 만들어주기

        WinnerResponseForm winnerResponseForm = new WinnerResponseForm(
                tmpSum, diceGameManager.checkWinIfSumEven(tmpSum));

        return winnerResponseForm;
        // 실행 잘 되는 것 확인!
        // 이제 vscode 가서 FrontEnd를 확인해준다
    }
}
