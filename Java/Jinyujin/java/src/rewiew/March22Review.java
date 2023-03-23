package rewiew;

import utility.random.CustomRandom;

public class March22Review {
    public static void main(String[] args) {
        // 주사위 4개 선언
//        int diceNumber1 = (int)(Math.random() * 6 + 1);
//        int diceNumber2 = (int)(Math.random() * 6 + 1);
//        int diceNumber3 = (int)(Math.random() * 6 + 1);
//        int diceNumber4 = (int)(Math.random() * 6 + 1);

        // 공통되는 것을 하나로 묶어버리자 -> 배열
        // diceNumberArray라는 변수에 배열 4개 생성
//        int[] diceNumberArray = new int[4];
//        // 배열 하나하나에 1~6까지 넣자 -> for문
//        for (int i = 0; i < diceNumberArray.length; i++) {
//            // diceNumberArray라는 이름으로 생성된 4개의 배열 하나하나에 1 ~ 6 까지 넣는다
//            diceNumberArray[i] = (int) (Math.random() * 6 + 1);
//        }

        // 숫자는 변수 이름으로 지정해주자
//        int MIN = 1;
//        int MAX = 6;
        int DICE_MAX = 4;
        // 이렇게 해두면 min, max, dice_max에 지정된 수가 변해도 여기서 숫자만 바꿔주면 OK
        int diceSum = 0;

//        int[] diceNumberArray = new int[DICE_MAX];
//        for (int i = 0; i < diceNumberArray.length; i++) {
//            diceNumberArray[i] = (int) (Math.random() * MAX + MIN);
//            //주사위 숫자의 합까지 여기서 지정
//            diceSum = diceSum + diceNumberArray[i];
//            // == diceSum += diceNumberArray[i];


        // 그런데 우리가 항상 MIN과 MAX 값을 따로 한 페이지에서 정해주어야 하는걸까? -> customrandom
        // custom random을 활용한 새로운 코드
        // 주사위 4개에 각각 1~6까지 넣는다는 사실을 기억하자
        int[] diceNumberArray2 = new int[DICE_MAX];
        for (int i = 0; i < diceNumberArray2.length; i++) {
        diceNumberArray2[i] = CustomRandom.generateNumber(1, 6) ;
        diceSum += diceNumberArray2[i];

        int WINNER_DECISION_NUMBER1 = 3;
        int WINNER_DECISION_NUMBER2 = 4;

        // 이제 주사위 합이 3이나 4의 배수가 되면 승리를 구해보자
        if (diceSum % WINNER_DECISION_NUMBER1 == 0 ||
                diceSum % WINNER_DECISION_NUMBER2 == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
        }



    }
}
