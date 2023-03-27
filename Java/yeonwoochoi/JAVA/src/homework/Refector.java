package homework;

class RefectorGame {

    int MAX_DICE_NUMBER = 12;
    int MAX = 6;
    int MIN = 1;
    int diceSum = 0;
    int[] diceNumberArray3;

    // Domain
    public RefectorGame () {
        // 굴리기 + 점수 합산
        diceNumberArray3 = new int[MAX_DICE_NUMBER];
        rollDice();         // Dice Domain
        sumDiceNumber();    // Score Domain
    }

    // 점수 합산
    private void sumDiceNumber() {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceSum += diceNumberArray3[i];
        }
    }

    // 주사위 굴리기
    public void rollDice() {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX);
            //(int) (Math.random() * MAX + MIN);;
        }
    }

    // 승리 판정
    public void checkWin() {
        if ((diceSum % 3 == 0) || (diceSum % 4 == 0)) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }

    public class Refector {
        public static void main(String[] args) {
            RefectorGame Game = new RefectorGame();
            // 변수명.함수이름();
            Game.checkWin();
        }
    }
}