package array;

import utility.random.CustomRandom;

public class Array {
    public static void main(String[] args) {

        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        int dice3 = (int) (Math.random() * 6 + 1);
        int dice4 = (int) (Math.random() * 6 + 1);
        // 같은 코드가 반복되면 배열과 반복문을 사용
        int diceSum = 0;
        int[] diceNumberArray2 = new int[4];
        for (int i = 0; i < 4; i++) {
            diceNumberArray2[i] = (int) (Math.random() * 6 + 1);
            diceSum += diceNumberArray2[i];
        }
        // 확장성을 고려하여 정수보단 변수로 치환
        int MAX_DICE_NUM = 4;
        int MAX = 6;
        int MIN = 1;

        int[] diceNumberArray3 = new int[MAX_DICE_NUM];

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            //diceNumberArray2[i] = (int)(Math.random() * MAX + MIN);
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX); // utility에서 작성한 랜덤코드를 사용
            diceSum += diceNumberArray3[i];
        }

        if ((diceSum % 3 == 0 || (diceSum % 4 == 0))) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
