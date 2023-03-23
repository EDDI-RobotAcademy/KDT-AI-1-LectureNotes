package homework.second.refactor;

import utility.random.CustomRandom;

class FirstRefactorGame{

    final int MIN = 1;
    final int MAX = 6;
    final int MAX_DICE_NUMBER = 4;
    int diceSum =0;
    int[] diceNumberArray3;
    public FirstRefactorGame(){
        // 굴리기 + 점수합산
        int[] diceNumberArray3 = new int[MAX_DICE_NUMBER];
        rollDice(); // Dice Domain
        sumDiceNumber(); // Score Domain
//        for(int i=0; i<MAX_DICE_NUMBER; i++){
//            diceNumberArray3[i] = CustomRandom.generateNumber(MIN,MAX);
//            diceSum += diceNumberArray3[i];
//        }
    }

    private void sumDiceNumber() {
        for(int i=0; i<MAX_DICE_NUMBER; i++){
            diceSum += diceNumberArray3[i];
        }
    }

    public void rollDice(){
        for(int i=0; i<MAX_DICE_NUMBER; i++){
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN,MAX);
        }
    }
    public void chkWin(){
        if((diceSum % 3 ==0) || (diceSum % 4 == 0)){
            System.out.println("승리!");
        }
        else {
            System.out.println("패배..");
        }
    }


}
public class FirstRefactor {
    public static void main(String[] args) {
        FirstRefactorGame firstRefactorGame = new FirstRefactorGame();
        firstRefactorGame.chkWin();
    }
}
