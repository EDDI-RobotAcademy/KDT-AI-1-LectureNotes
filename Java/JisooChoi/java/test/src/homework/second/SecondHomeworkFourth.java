package homework.second;

import utility.random.CustomRandom;

public class SecondHomeworkFourth {
    public static void main(String[] args) {
        int diceNumber1 = (int) (Math.random() * 6 + 1);
        int diceNumber2 = (int) (Math.random() * 6 + 1);
        int diceNumber3 = (int) (Math.random() * 6 + 1);
        int diceNumber4 = (int) (Math.random() * 6 + 1);

        // 1. 동일한 형태의 코드가 반복되고 있음
        // ->
        // 배열 만들고 싶은데 ?
        int[] diceNumberArray = new int[4];
        for(int i = 0; i < diceNumberArray.length; i++){
            diceNumberArray[i] = (int) (Math.random() * 6 + 1);
        }

        // 2. 어쨋든 배열을 만들었는데 숫자가 적혀 있어서 싫음
        // 랜덤을 만들 때도 숫자가 들어있어서 싫음
        int MAX_DICE_NUM = 4;
        int MAX = 6;
        int MIN = 1;

        int diceSum = 0;

        int[] diceNumberArray2 = new int[MAX_DICE_NUM];
        for(int i = 0; i < diceNumberArray.length; i++){
            // 앞으로도 랜덤이 필요하면 매번 반복할 것 같은데
            // 매번 이렇게 MAX, MIN 지정해야 하나 ?
            // 그리고 MIN = 3, MAX = 6이면
            // 현재 코드에선 3 ~ 8까지 표현되겠네 ?
            //diceNumberArray2[i] = (int) (Math.random() * MAX + MIN);
            diceNumberArray2[i] = CustomRandom.generateNumber(MIN, MAX);
            diceSum += diceNumberArray2[i];
        }

        if((diceSum % 3 == 0) || (diceSum % 4 == 0)){
            System.out.println("승리 !");
        }else {
            System.out.println("패배 !");
        }
    }
}
