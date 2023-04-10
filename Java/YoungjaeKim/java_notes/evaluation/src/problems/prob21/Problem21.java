package problems.prob21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customLibrary.CustomRandom;
import customLibrary.Employee;

public class Problem21 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int SALARY_INCREASE_MIN = 1;
        final int SALARY_INCREASE_MAX = 50;
        int employeeCount = 4;

        double increase = 0;
        double increaseSalary = 0;
        int tenYearsLater = 0;

        for (int i = 0; i < employeeCount; i++) {
            System.out.print("직원 이름 입력 : ");
            String name = scanner.nextLine();

            int salaryIncrease = CustomRandom.generateNumber(SALARY_INCREASE_MIN, SALARY_INCREASE_MAX);
            Employee employee = new Employee(name, salaryIncrease);

            increase = 1 + ((double) employee.getSalaryIncrease() / 100);

            // 1년째 인상된 연봉
            increaseSalary = employee.getSalary() * increase;
            // 앞으로 9년 후의 연봉
            for (int j = 0; j < 9; j++) {
                increaseSalary = (increaseSalary * increase);
            }

            System.out.println("직원 이름 : " + employee.getName() +
                    ", 직원 초봉 : " + employee.getSalary() +
                    ", 연봉 인상률 : " + increase +
                    ", 10년 후의 연봉 : " + increaseSalary);
        }
    }
}
