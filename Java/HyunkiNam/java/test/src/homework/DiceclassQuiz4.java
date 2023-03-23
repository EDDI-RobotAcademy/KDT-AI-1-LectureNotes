package homework;

import utility.random.CustomRandom;

public class DiceclassQuiz4 {
    public static void main(String[] args) {

        int diceNumber1 = (int) (Math.random() * 6 + 1);
        int diceNumber2 = (int) (Math.random() * 6 + 1);
        int diceNumber3 = (int) (Math.random() * 6 + 1);
        int diceNumber4 = (int) (Math.random() * 6 + 1);

        // 동일한 형태의 코드가 반복되고 있음
        // ->
        // 배열 만들고 싶은데 ?
        int[] diceNumberArray = new int[4];
        for (int i = 0; i < diceNumberArray.length; i++) {
            diceNumberArray[i] = (int) (Math.random() * 6 + 1);
        }

        // 어쨋든 배열을 만들었는데 숫자가 적혀 있어서 싫음
        int MAX_DICE_NUM = 12;

        int[] diceNumberArray2 = new int[MAX_DICE_NUM];
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceNumberArray2[i] = (int) (Math.random() * 6 + 1);
        }
        // 랜덤을 만들 때도 숫자가 들어있어서 싫음.
        final int MAX_DICE_NUMBER = 4;
        final int MIN = 1;
        final int MAX = 6;

        int dicesum =0;
        int[] diceNumberArray3 = new int[MAX_DICE_NUMBER];

        for(int i=0; i<MAX_DICE_NUMBER; i++){
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN,MAX);
            dicesum += diceNumberArray3[i];
        }
        if((dicesum % 3 ==0) || (dicesum % 4 == 0)){
            System.out.println("승리!");
        }
        else {
            System.out.println("패배..");
        }
    }
}
