package problems.prob21;

import problems.CustomRandom;

// 초봉은 2000만원입니다. 직원들의 연봉 인상률은 1 ~ 50% 입니다 연봉 인상률은 랜덤으로 지정해주세요.
// 직원은 4명을 배치하고 이름은 적당히 지어줍니다. 10년 후 각자의 연봉을 출력해보도록 합시다.
public class Employees {
    private String name;
    private int income;

    public Employees(String name) {
        this.name = name;
        this.income = 2000000;
    }
    public void increaseIncome () {
        final float increaseRate = (float) CustomRandom.generateNumber(1,50) / 100.0f;

        income = (int) ((1 + increaseRate) * income);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", income=" + income +
                '}';
    }

}
