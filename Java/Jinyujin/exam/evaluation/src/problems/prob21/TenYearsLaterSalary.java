package problems.prob21;

import customLibrary.CustomRandom;

// 초봉 2000만원
// 연봉 인상률 1~50 랜덤값
public class TenYearsLaterSalary {
    final private int FIRST_SALARY = 2000;
    final private int UP_MIN = 1;
    final private int UP_MAX = 50;
    final private int CAN_MAKE_PERCENT = 100;
    int grownSalary;

    public void printSalary() {
        int upPercent = CustomRandom.generateNumber(UP_MIN, UP_MAX);

        // 연봉인상률 랜덤으로 지정 -> 인상된 연봉
        // 2000+(2000*upPercent/100)
        grownSalary = FIRST_SALARY + (FIRST_SALARY*upPercent/CAN_MAKE_PERCENT);
        System.out.println(grownSalary);
    }

    public void peopleSalary() {
        // 10년 동안 연봉이 누적 상승인데..
        int tenYearsLaterSalary = 0;

        for (int i = 0; i < 10; i++) {
            tenYearsLaterSalary = grownSalary * i;
        }

        System.out.println(tenYearsLaterSalary);
    }
}
