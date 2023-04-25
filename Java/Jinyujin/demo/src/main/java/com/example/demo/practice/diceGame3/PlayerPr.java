package com.example.demo.practice.diceGame3;

import com.example.demo.practice.diceGame3.DicePr;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PlayerPr {
    // 여기서는 주사위 정보 가지고 있었음
    // 주사위 클래스를 타입으로 갖는 주사위 리스트 가져오기
    private List<DicePr> dicePrList;

    public PlayerPr(int maxDiceNumber, int conditionDiceIdx) {
        final int EVEN_DICISION = 2;
        final int ODD = 1;

        int diceSum = 0;

        // 첫 번째 조건 만족시켜주기
        for (int i = 0; i < maxDiceNumber; i++) {
            // 주사위 조건에 관한 것 -> 주사위 개수만큼 돌아서 첫 번째 주사위 찾아야 함
            // 주사위 리스트 만들어주기

            DicePr dicePr = new DicePr(); // 이거 지금 주사위임

            dicePrList.add(dicePr);
            diceSum += dicePr.getDiceNumber();
            // diceSum도 객체로 만든 것으로 구함...!

            // 첫 번째 주사위 조건
            // 그 조건에 맞는 인덱스가 필요
            if (i == conditionDiceIdx){
                if (dicePr.getDiceNumber() % EVEN_DICISION == ODD) {
                break;
                }
            }
        }
    }
}
