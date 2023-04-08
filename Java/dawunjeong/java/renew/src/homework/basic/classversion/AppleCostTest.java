package homework.basic.classversion;

public class AppleCostTest {
    public static void main(String[] args) {
        final int APPLE_COST_MIN = 5000;
        final int APPLE_COST_MAX = 10000;

        Apple apple = new Apple(APPLE_COST_MIN,APPLE_COST_MAX);

        apple.acquireApples();
        final int totalAppleCost = apple.calculateCost();
        System.out.println("전체 사과의 가격: " + totalAppleCost);
    }
}
