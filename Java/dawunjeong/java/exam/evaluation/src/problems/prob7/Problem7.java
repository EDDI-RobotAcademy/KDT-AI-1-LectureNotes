package problems.prob7;

import customLibrary.RandomGenerator;

class FixAppleCost{
    private int appleCost = 2000;
    final private int MIN = 3;
    final private int MAX = 20;
    final int rateOfIncrease;

    public FixAppleCost() {
        rateOfIncrease = RandomGenerator.generateNumber(MIN,MAX);
        appleCost = (int) (appleCost * (1 + (0.01 * rateOfIncrease)));
    }

    public int getAppleCost() {
        return appleCost;
    }

    public int getRateOfIncrease() {
        return rateOfIncrease;
    }
}
public class Problem7 {
    public static void main(String[] args) {
        FixAppleCost appleCost = new FixAppleCost();
        System.out.println("사과의 가격: " + appleCost.getRateOfIncrease()
                + "% 인상되어 "+ appleCost.getAppleCost() + "원 입니다.");
    }
}
