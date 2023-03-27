package lectureClass.solFirstRefactor;

import utility.random.CustomRandom;

class FirstRefactorGame {
    int MAX_DICE_NUM = 4;

    public void setMAX_DICE_NUM(int MAX_DICE_NUM) {
        this.MAX_DICE_NUM = MAX_DICE_NUM;
    }

    int MAX = 6;
    int MIN = 1;
    int diceSum = 0;
    int[] diceNumberArray;

    public FirstRefactorGame() {

        diceNumberArray = new int[MAX_DICE_NUM];
        // rolldice() + sumDiceNumber()
        rollDice(); // Dice Domain
        sumDiceNumber(); // Score Domain

    }

    private void sumDiceNumber() {
        for (int i = 0; i < MAX_DICE_NUM; i++) {

            diceSum += diceNumberArray[i];
        }
    }

    public void rollDice() {
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            // 앞으로도 랜덤이 필요하면 매번 반복할 것 같은데
            // 매번 이렇게 MAX MIN 지정해야 하나?
            // 그리고 MIN=3, MAX=6이면
            // 현재 코드에선 3~8 까지 표현되겠네?
            diceNumberArray[i] = CustomRandom.generateNumber(MIN, MAX);

        }
    }

    public void checkWin() {
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

