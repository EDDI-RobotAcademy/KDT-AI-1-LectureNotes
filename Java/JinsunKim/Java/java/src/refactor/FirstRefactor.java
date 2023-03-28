package refactor;


import utility.random.CustomRandom;

class FirstRefactorGame {
    int diceSum = 0;
    int MAX_DICE_NUMBER = 4;
    int MAX = 6;
    int MIN = 1;
    int[] diceNumberArray3;

    public FirstRefactorGame() {
        // 4번째 굴리기 + 점수 합산
        diceNumberArray3 = new int[MAX_DICE_NUMBER];
        rollDice(); //dice domain
        sumDiceNumber(); // score domain
    }

    //5번째
    public void sumDiceNumber () {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceSum += diceNumberArray3[i];
        }
    }

    //6번째
    private void rollDice() {
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN,MAX);
        }
    }

    public void checkWin() { //2번째 작성
        if ((diceSum % 3 == 0) || (diceSum % 4 == 0)) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
public class FirstRefactor {
    public static void main(String[] args) {

        FirstRefactorGame frGame = new FirstRefactorGame(); //1번째 작성
        frGame.checkWin(); //3번째 작성
    }
}

