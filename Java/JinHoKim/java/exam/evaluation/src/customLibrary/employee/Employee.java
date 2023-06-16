package customLibrary.employee;

import customLibrary.utility.random.CustomRandom;

public class Employee {
    private String name;
    private int income;

    public Employee(String name) {
        this.name = name;
        this.income = 20000000;
    }

    public void increaseIncome () {
        final float increaseRate = (float) CustomRandom.generateNumber(1, 50) / 100.0f;
        income = (int)((1 + increaseRate) * income);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", income=" + income +
                '}' + '\n';
    }
}
