package com.example.demo.practice.diceGame3;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DiceGameManagerPr {
    // 플레이어에 대한 정보 가짐
    // 플레이어를 타입으로 갖는 플레이어 리스트 초기화
    // 플레이어 수 변할 수 있기 때문에 final 설정하지 않는다
    private List<PlayerPr> playerPrList;

    // 플레이어와 주사위 개수를 매개변수로 갖는 생성자 생성해야 함

    public DiceGameManagerPr(int playerNumber, int maxDiceNumber) {
        // 플레이어 리스트에 추가해주기
        playerPrList = new ArrayList<>();

        final int CONDITION_DICE_IDX = 0; // 배열에서 첫번째 주사위

        for (int i = 0; i < playerNumber; i++) {
            PlayerPr playerPr = new PlayerPr(maxDiceNumber, CONDITION_DICE_IDX);
            // 새로운 방식인 거 같음
            // 플레이어 클래스에서 플레이어 객체를 새로 생성해주고
            // 그걸로 플레이어 리스트를 만들어줌
            // 주사위 3개 굴리는 플레이어 리스트 완성
            playerPrList.add(playerPr);
        }
    }

    public void applyCondition() {
        // 세 번째 주사위에 대한 조건 생성

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -777;

        for (int i = 0; i < playerPrList.size(); i++) {
            // 지금 굴리는 플레이어의 주사위가 뭔지 파악해주어야 함
            // 현재 플레이어 파악해주어야 함 -> 플레이어 클래스로
            PlayerPr currentPlayer = playerPrList.get(i);

            // 현재 플레이어 주사위 합 선언해 줘야함
            ;
        }
    }
}
