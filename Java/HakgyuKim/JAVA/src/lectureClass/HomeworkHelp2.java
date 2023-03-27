package lectureClass;

import utility.random.CustomRandom;

public class HomeworkHelp2 {

    public static void main(String[] args) {


        int diceNumber1 = (int) (Math.random() * 6 + 1);
        int diceNumber2 = (int) (Math.random() * 6 + 1);
        int diceNumber3 = (int) (Math.random() * 6 + 1);
        int diceNumber4 = (int) (Math.random() * 6 + 1);

        // 동일한 형태의 코드가 반복되고 있음
        // ->
        // 배열 만들고 싶은데?

        int[] diceNumberArray = new int[4];
        for (int i = 0; i < diceNumberArray.length; i++) {
            diceNumberArray[i] = (int) (Math.random() * 6 + 1);
        }

        // 배열은 만들었는데 숫자가 들어있어서 싫음
        int MAX_DICE_NUM = 4;

        int[] diceNumberArray2 = new int[MAX_DICE_NUM];
        for (int i = 0; i < diceNumberArray2.length; i++) {
            diceNumberArray2[i] = (int) (Math.random() * 6 + 1);
        }

        // 랜덤 숫자도 빼기
        int DICE_MAX_NUM = 4;
        int MAX = 6;
        int MIN = 1;

        int diceSum = 0;

        int[] diceNumberArray3 = new int[MAX_DICE_NUM];
        for (int i = 0; i < diceNumberArray3.length; i++) {
            // 앞으로도 랜덤이 필요하면 매번 반복할 것 같은데
            // 매번 이렇게 MAX, MIN 지정해야하나?
            // 그리고 MIN = 3, MAX = 6이면
            // 현재 코드에선 3 ~ 8까지 표현 되겠네?
            // diceNumberArray3[i] = (int) (Math.random() * (MAX + MIN));
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX);
            diceSum += diceNumberArray3[i];
        }

        if ((diceSum % 3 == 0) || (diceSum % 4 == 0)) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}


