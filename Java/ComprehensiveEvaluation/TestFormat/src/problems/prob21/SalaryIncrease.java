package problems.prob21;

import customLibrary.CustomRandom;

public class SalaryIncrease {
    private final int BASICSALARY = 2000;
    private final int YEARSLATER = 10;
    private int increaseRate;
    private final int MIN_RATE = 1;
    private final int MAX_RATE = 50;
    private float finalSalary;

    public SalaryIncrease() {
        this.increaseRate = increaseRate;
        this. finalSalary = finalSalary;
    }

    public float getFinalSalary() {
        for(int i = 0; i < 10; i++) {
            increaseRate = CustomRandom.generateNumber(MIN_RATE, MAX_RATE);
            finalSalary = BASICSALARY*(1+(increaseRate/100f));
        }
        return finalSalary;
    }
}
