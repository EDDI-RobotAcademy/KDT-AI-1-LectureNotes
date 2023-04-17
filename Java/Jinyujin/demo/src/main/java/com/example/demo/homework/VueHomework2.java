package com.example.demo.homework;
// 2. 이전에 풀어봤던 주사위 문제 [ 3 ]을 Vue와 Spring 버전으로 변형해서 풀어봅시다!
// 친구와 1:1이 아닌 컴퓨터와 1:1인 상황이라 생각해도 됩니다.
// (푸는 방식은 동일하기 때문)

// 친구와 게임을 할 수 있습니다.
// 1:1 게임이라 가정하겠습니다.
// 주사위를 3개 굴립니다.
// 첫 번째 주사위가 짝수라면
// 두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.
// 두 번째 주사위는 특수 기능이 별도로 존재하지 않습니다.
// 세 번째 주사위는 숫자 1인 경우 친구에게 점수를 3점 뺏을 수 있습니다.
// 숫자가 3인 경우엔 자신에게 2점을 가산합니다.
// 숫자가 4인 경우엔 무조건 패배하게 됩니다.
// 친구와 함께 플레이 할 수 있는 주사위 게임을 만들어주세요.

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vue-homework")
public class VueHomework2 {
    @GetMapping("/vue-dice-three")
    public String getRandomDice() {
        final int MIN = 1;
        final int MAX = 6;

        final int DICE_COUNT = 3;
        final int EVEN_DECISION = 2;
        final int ODD = 1;

        final int PLAYER_COUNT = 2;
        final List<Integer> playerList = new ArrayList<>();

        // 플레이어 리스트 생성
        for (int i = 0; i < PLAYER_COUNT; i++) {
            playerList.add(i);
        }

        final List<Integer> diceList = new ArrayList<>();

        final int FIRST_DICE_INFO = 0;
        final int THIRD_DICE_INFO = 2;

        final int STEAL_NUMBER = 1;
        final int BUFF_NUMBER = 3;
        final int DEATH_NUMBER = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -999;

        // 주사위 3개 생성
        // 주사위 3개 합 생성
        int diceSum = 0;
        int totalScore;

        // 주사위 굴리기
        for (int i = 0; i < DICE_COUNT; i++) {
            diceSum = diceList.get(CustomRandom.generateNumber(MIN, MAX));

            // 첫 번째 주사위가 홀수라면 멈춰라
            if (diceList.get(FIRST_DICE_INFO) % EVEN_DECISION == ODD) {
                break;
            }
            if (diceList.get(THIRD_DICE_INFO) == DEATH_NUMBER) {
//                playerList.get(i)의 점수는 DEATH_SCORE;
            }
            if (diceList.get(THIRD_DICE_INFO) == BUFF_NUMBER) {
                // i번째 플레이어 점수에 2점 추가
            }
            if (diceList.get(THIRD_DICE_INFO) == STEAL_NUMBER) {
                // 상대 플레이어 점수에서 3점 빼고
                // 현재 플레이어 점수에서 3점 더해라
            }
        }

        // 최종점수 나타내기

        return null;
    }
}
