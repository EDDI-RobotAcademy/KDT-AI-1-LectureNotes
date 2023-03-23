package homework.refactor;

import utlity.CustomRandom;

class FirstRefactorGame {
    public FirstRefactorGame () {

    int MAX_DICE_NUMBER = 3;
    int MAX = 6;
    int MIN = 1;

    int diceSum = 0

    int[] diceNumberArray3 = new int[MAX_DICE_NUMBER];
        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
        //  앞으로도 랜덤이 필요하면 매번 반복할 것 같은데
        //  매번 이렇게 MAX, MIN 지전해야 하나?
        //  그리고 MIN =3, MAX = 6이면
        //  현재 코드에선 3 ~ 8까지 표현 되겠네?
        //diceNumberArray3[i] = (int) (Math.random() * MAX + MIN);
        diceNumberArray3[i] = CustomRandom.getRandomNumber(MIN, MAX);
        diceSum += diceNumberArray3[i];
        }


    }

    public void checkWin () {
        if ((diceSum % 3 == 0) || (diceSum % 4 ==0)) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}
public class FirstRefactor {
    public static void main(String[] args) {


    }

}
