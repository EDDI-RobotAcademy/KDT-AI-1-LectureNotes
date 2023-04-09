package basicTest.apple;

public class RandomAppleCostTest {
    // 가격정의와 사과의 갯수 매치
    public static void main(String[] args) {
//        final int APPLE_COST_MIN = 5000;
//        final int APPLE_COST_MAX = 10000;
//
//        RandomApple randomApple = new RandomApple(APPLE_COST_MIN,APPLE_COST_MAX);
//
//        randomApple.acquireApples();
//        final int totalAppleCost = randomApple.calculateCost();
//
//        System.out.println("전체 사과의 가격: " + totalAppleCost);
        Apple apple = new Apple();
        Price price = new Price();
        System.out.println(price);
        System.out.println("사과의 총합: " + price.priceSum());
    }
}
