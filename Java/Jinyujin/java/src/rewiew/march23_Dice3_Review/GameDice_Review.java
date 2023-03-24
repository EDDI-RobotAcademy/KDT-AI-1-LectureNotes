package rewiew.march23_Dice3_Review;

// 일단 주사위 개수 - 3개
// 굴리기

import utility.random.CustomRandom;

public class GameDice_Review {

    final int MAX_DICE_NUMBER = 3;
    final int diceNumber;
    final int MIN = 1;
    final int MAX = 6;

    public GameDice_Review(int diceNumber,) {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            this.diceNumber = CustomRandom.generateNumber(1,6);

        }

        public int getDiceNumber() {
            return diceNumber;
        }
    }


}
