package homework.homework2;

import utility.random.CustomRandom;

public class homework2 {

    public static void main(String[] args) {

        int dicenumber1 =(int) (Math.random() * 6 + 1);
        int dicenumber2 =(int) (Math.random() * 6 + 1);
        int dicenumber3 =(int) (Math.random() * 6 + 1);
        int dicenumber4 =(int) (Math.random() * 6 + 1);

        /*
        동일한 코드가 반복됨
        배열을 만들고 싶음
         */

        int[] diceNumberArry = new int[4];
        for (int i = 0; i< diceNumberArry.length; i++){
            diceNumberArry[i] = (int) (Math.random() * 6 +1);
        }

        //랜덤을 만들때 숫자가 들어있어서 싫음
        int MAX_DICE_NUB = 12;
        int[] diceNumberArry2 = new int[MAX_DICE_NUB];
        for (int i = 0; i< diceNumberArry2.length; i++){
            diceNumberArry2[i] = (int) (Math.random() * 6 +1);
        }

        int MAX = 6;
        int MIN = 1;
        int diceSum = 0;

        int[] diceNumberArray3 = new int[MAX_DICE_NUB];
        for (int i = 0; i< MAX_DICE_NUB; i++){
            /*
            앞으로도 랜덤이 필요하면 매번 반복할 것 같은데
            매번 이렇게 MAX,MIN 지정해야하나?
            그리고 현재 MIN=3, MAX=6 이면
            현재 코드에선 3~8까지 표현되겠네?
            */
            //diceNumberArray3[i] = (int) (Math.random() * MAX +MIN);
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX);
            diceSum += diceNumberArray3[i];
        }

        if ((diceSum % 3 == 0) || (diceSum % 4 == 0)) {
            System.out.println("승리");
        } else  {
            System.out.println("패배");
        }

    }

}
