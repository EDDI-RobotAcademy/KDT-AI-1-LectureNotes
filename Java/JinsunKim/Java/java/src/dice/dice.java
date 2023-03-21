package dice;

public class dice {
    public static void main(String[] args) {

        //주사위 개수
        final int NUM = 2;
        //주사위 합
        int sum = 0;

        //랜덤뽑기 , 총 합
        for (int i = 0; i < NUM; i++) {
            int randomNumber = (int)(Math.random() * 6) +1;
            sum += randomNumber;
        }
        System.out.println("합계 = " + sum);

        //결과
        if (sum % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
