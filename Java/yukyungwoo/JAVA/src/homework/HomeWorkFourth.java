package homework;

import utlity.CustomRandom;

public class HomeWorkFourth {
    public static void main(String[] args) {
        int diceNumber1 = (int) (Math.random() * 6 + 1);
        int diceNumber2 = (int) (Math.random() * 6 + 1);
        int diceNumber3 = (int) (Math.random() * 6 + 1);
        int diceNumber4 = (int) (Math.random() * 6 + 1);

        //  동일한 형태의 코드가 반복되고 있음
        //  ->
        //  배열 만들고 싶은데?

        int[] diceNumberArray;


        int MAX_DICE_NUMBER = 12;
        int MAX = 6;
        int MIN = 1;

        int diceSum = 0;

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

        if ((diceSum % 3 == 0) || (diceSum % 4 ==0)) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }




    }
}
