package test.apple;

public class AppleTest {
    public static void main(String[] args) {
        int MIN = 5000;
        int MAX = 10000;
        Apple apple = new Apple(MIN,MAX);

        apple.RandomCostApple();
        int totalApple = apple.calculateCost();
        System.out.println(totalApple);
    }
}
