package homework.second.refactor;

import utility.random.CustomRandom;

class FirstRefactorGame {

    int MAX = 6;
    int MIN = 1;
    int MAX_DICE_NUMBER = 3;
    int diceSum = 0;
    int[] diceNumberArray3;

    public FirstRefactorGame () {
        // 굴리기 + 점수 합산
        diceNumberArray3 = new int[MAX_DICE_NUMBER];
        rollDice();         // Dice Domain
        sumDiceNumber();    // Score Domain
    }

    private void sumDiceNumber() {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceSum += diceNumberArray3[i];
        }
    }

    public void rollDice () {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX);
        }
    }

    public void checkWin () {
        if ((diceSum % 3 == 0) || (diceSum % 4 == 0)) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}

public class FirstRefactor {
    public static void main(String[] args) {
        FirstRefactorGame frGame = new FirstRefactorGame();
        frGame.checkWin();
    }
}
