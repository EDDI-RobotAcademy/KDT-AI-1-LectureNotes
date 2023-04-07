package dice3.TeacherDice;

import dice3.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class ReviewDice3 {
    int START = 0;
    int diceDog = 3; // 주사위 갯수
    int diceJJak = 2; // 짝수 일 때 쓰일 숫자.
    int MAX_Dice = 6;
    int MIN_Dice = 1;
    List<Integer> dice = new ArrayList<>();

    public List<Integer> rollDice() {
        dice.clear();
        // diceDog은 Anti-Pattern 입니다.
        for (int i = START; i < diceDog; i++) {
            // diceJJak도 EVEN_DECISION이라고 명시 해주는 것이 더 좋을 것 같습니다.
            // 숫자 0을 EVEN이라고 해서 바로 보고
            // 짝수 판정이구나라는 것을 표현해주면 좋을 것 같습니다.
            dice.add(CustomRandom.generateNumber(MIN_Dice,MAX_Dice));
            // 홀수 상황에서 두 번째 주사위와 세 번째를 돌릴 수 있으니까
            // 표현이 == 0이 아니라 == 1이고 1이였다면
            // ODD라고 표현 했으면 더 좋았을 것 같습니다.
            if (dice.get(0) % diceJJak == 1) {
                dice.add(0);
                dice.add(0);
                break;
            }
        }

        return dice;
    }
}