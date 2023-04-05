package basicProblem;

public class BasicProblem {

    public static void main(String[] args) {

        final int number = 100;
        final int START = 1;

        System.out.println("⭐️ 짝수만 출력하기 ⭐");
        for (int i = START; i <= number; i++){
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("⭐ 3의 배수만 출력하기 ⭐");
        for (int i = START; i <= number; i++){
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("⭐ 4의 배수를 다 더하기 ⭐");
        int sum = 0;
        for (int i = START; i <= number; i++){
            if (i % 4 == 0){
                sum += i;
                System.out.print(sum + " ");
            }
        }
        System.out.println();
        System.out.println("최종 합 : " + sum);

        System.out.println("⭐ 사과의 가격을 랜덤값을 가지게 만들기 ⭐");

        int applePriceMIN = 5000;
        int applePriceMAX = 10000;
        int appleAcquireNumber = (int) (Math.random() * (5 - 3 + 1) + 3);
        int sumApplePrice = 0;
        for (int i = START; i <= appleAcquireNumber; i++){
            int applePrice = (int) (Math.random() * (applePriceMAX - applePriceMIN + 1)+ applePriceMIN);
            sumApplePrice += applePrice;
            System.out.println(i + " 번째 사과 가격 : " + applePrice + ", 현재 총 가격 : " + sumApplePrice);

        }
        System.out.println("모두 " + sumApplePrice + " 원 나왔습니다 ㅎ");
        System.out.println();







    }


}
