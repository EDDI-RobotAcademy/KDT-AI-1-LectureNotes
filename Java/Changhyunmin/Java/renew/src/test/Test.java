package test;

public class Test {
    public static void main(String[] args) {
        int MIN = 1;
        int MAX = 100;
        int First = 2;
        int Second = 3;
        int Third = 4;
        int total = 0;

        //01.문제

        for (int i = MIN; i <= MAX; i++){
            if (i % First == 0) {
                System.out.println(i);
            }
        }
        //02.문제

        for (int i = MIN; i <= MAX; i++){
            if (i % Second == 0){
                System.out.println(i);
            }
        }
        //03.문제

        for (int i = MIN; i <= MAX; i++){
            if (i % Third == 0) total += i;
            else continue;
            System.out.println("초기값: " + i +  ", 합: " + total);
        }
        System.out.println("총합: " + total);

        int Min = 5000;
        int Max = 10000;
        int price;
        int min = 3;
        int max = 5;
        int apple;
        int TotalApple = 0;
        int TotalPrice = 0;

        //04.문제

        for (int i = 0; i < 3; i++){
            price = (int)(Math.random()*(Max - Min)) + Min;
            System.out.println("가격: " +  price);
            TotalPrice += price;

        //05.문제

            apple = (int)(Math.random()*(max - min)) + min;
            System.out.println("사과: " + apple);
            TotalApple += apple;
        }
        //06.문제
        System.out.println("사과의 합: " + TotalApple + ", 총 수입: " + TotalPrice);
    }
}
