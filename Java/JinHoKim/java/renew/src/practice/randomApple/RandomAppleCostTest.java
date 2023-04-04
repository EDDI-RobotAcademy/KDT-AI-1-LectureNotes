package practice.randomApple;

public class RandomAppleCostTest {
    public static void main(String[] args) {
        final int APPLE_COST_MIN = 5000;
        final int APPLE_COST_MAX = 10000;

        RandomApple randomApple = new RandomApple(APPLE_COST_MIN, APPLE_COST_MAX);
        randomApple.acquireApples();
        final int totalAppleCost = randomApple.calculateCost();

        System.out.println(totalAppleCost);
    }
}
