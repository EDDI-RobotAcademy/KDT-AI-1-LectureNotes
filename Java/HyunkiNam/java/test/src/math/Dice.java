package math;

public class Dice {
    public static void main(String[] args) {
        final int MAX = 6;
        final int MIN = 1;

        final int randomValue1 = (int)(Math.random() * (MAX-MIN+1)) + MIN;
        final int randomValue2 = (int)(Math.random() * (MAX-MIN+1)) + MIN;

        final int sum = randomValue1 + randomValue2; // final 추가

        final int winner_condition = 4; // 승리 조건 상수화

        System.out.println("주사위 1의 값 : " + randomValue1
                + ", 주사위 2의 값 : "+randomValue2+", 합 : "+sum);
        if(sum % winner_condition == 0) // 4 -> winner_condition으로 변경
            System.out.println(sum+"은(는) 4의 배수 이므로 승리!");
        else
            System.out.println(sum+"은(는) 4의 배수가 아니므로 패배..");
    }
}