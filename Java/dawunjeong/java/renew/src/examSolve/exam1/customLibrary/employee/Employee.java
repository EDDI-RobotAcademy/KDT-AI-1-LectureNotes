package examSolve.exam1.customLibrary.employee;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

public class Employee {
    // 직원은 이름과 연봉이 있다.
    private String name;
    private int income;

    // 초봉은 2000만원
    public Employee(String name) {
        this.name = name;
        this.income = 20000000;
    }

    // 연봉 인상
    public void increaseIncome () {
        // 1~50%까지 인상 가능
        final float increaseRate = (float) CustomRandomNumber.generateRandomNumber(1, 50) / 100.0f;
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
