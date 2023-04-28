package DiceGame.Player;


import homework.CustomRandom;

public class GameDice {
        final private int MIN = 1;  // 최소 값
        final private int MAX = 6;  // 최대 값
        final private int diceNumber;   // 주사위

        public GameDice() {
            // CustomRandom 미리 만들어놓은 코드를 사용함
            // 1 ~ 6까지의 램덤 주사위
            this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
        }

        // 다른 외부 작업시 필요한 정보를 사용하려고 만듬
        // 결론적으로 정보를 외부에서 뽑아서 사용하는 경우가 없다면 getter를 만들어 줄 필요가 없음
        public int getDiceNumber() {
            return diceNumber;
        }

        // 단순히 출력 목적을 가지고 있을 때 toString()을 사용함

    @java.lang.Override
    public java.lang.String toString() {
        return "GameDice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}

