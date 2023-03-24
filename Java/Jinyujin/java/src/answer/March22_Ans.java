package answer;

import utility.random.CustomRandom;

public class March22_Ans {
    public static void main(String[] args) {

        int diceNumber1 = (int)(Math.random() * 6 + 1);
        int diceNumber2 = (int)(Math.random() * 6 + 1);
        int diceNumber3 = (int)(Math.random() * 6 + 1);
        int diceNumber4 = (int)(Math.random() * 6 + 1);
        // 동일한 형태의 코드가 반복되고 있음
        // -> 배열 만들고 싶은데? 라는 생각이 들어야 함!
        int[] diceNumberArray = new int[4];
        for (int i =0; i < diceNumberArray.length; i++) {
            diceNumberArray[i] = (int)(Math.random() * 6 + 1);
        }

        // 어잿든 배열을 만들었는데 숫자가 적혀 있어서 싫음
        int MAX_DICE_NUM = 4;

        int[] diceNumberArray2 = new int[MAX_DICE_NUM];
        for (int i =0; i < diceNumberArray2.length; i++) {
            diceNumberArray2[i] = (int) (Math.random() * 6 + 1);
            // [] [] [] []
            //  0  1  2  3
            // 첫번째 배열에 1~6까지 랜덤 하나 -> 4번째 배열까지
        }
        //... 이렇게 하면 나중에  int MAX_DICE_NUM = 4; 여기서 4는 아무 수로 바꿔도 식을 변경해주지 않아도 되니 편함

        // 랜덤을 만들 때도 숫자가 들어있어서 싫음
        int MAX_DICE_NUM2 = 12;
        int MAX = 6;
        int MIN = 1;

        int diceSum = 0;

        // 데이터타입 배열열고 변수이름설정 = new 데이터타입 12개를 만들겠다
        // [][][][][][][][][][][][]
        // 배열의 시작은 0부터
        // 이 공간 하나에 int 저장
        int[] diceNumberArray3 = new int[MAX_DICE_NUM2];
        for (int i =0; i < diceNumberArray3.length; i++) {
            // 앞으로도 랜덤이 필요하면 매번 반복할 것 같은데
            // 매번 이렇게 MAX, MIN 지정해야 하나?
            // 그리고 MIN = 3, MAX = 6이면
            // 현재 코드에선 3 ~ 8까지 표현되겠네?
            //... 이런식으로 계속 생각해봐야 한다
            //... (int) (Math.random() * MAX + MIN) 을 어디서든 쓸 수 있는 유틸리티로 만들어버리기
            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX); //... 이렇게 만들어두면 굳이 주사위가 아니더라도 min, max값이 필요할 때 얘를 부르면 됨
            diceSum += diceNumberArray3[i];
        }

        if ((diceSum % 3 == 0) || ((diceSum & 4) == 0)) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
        //... 확실히 class를 만들었을 때 더 간편하게 쓸 수 있고 제3자도 알아보기 편함
        // 제 3자는 사용자가 될 수도 있음
        // 우리는 tmi를 최대한 줄일 수 있는 코드를 써야 한다
        // 리팩터링 해보자
    }
}
