package problems.prob21;

import customLibrary.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Problem21 {
    public static void main(String[] args) {
        final int EMPLOYEE_NUMBER = 4;
        final int YEAR_NUMBER = 10;
        List<Employee> employeeList = new ArrayList<>();
        String[] nameArray = { "안녕", "하이", "곤니치와", "곰방와" };

        initEmployee(employeeList, nameArray);
        System.out.println(employeeList);

        tenYearsAgo(EMPLOYEE_NUMBER, YEAR_NUMBER, employeeList);
        System.out.println(employeeList);
    }

    private static void tenYearsAgo(
            int EMPLOYEE_NUMBER,
            int YEAR_NUMBER,
            List<Employee> employeeList
    ) {
        for (int i = 0; i < YEAR_NUMBER; i++) {
            for (int j = 0; j < EMPLOYEE_NUMBER; j++) {
                employeeList.get(j).increaseIncome();
            }
        }
    }

    private static void initEmployee(List<Employee> employeeList, String[] nameArray) {
        for (int i = 0; i < 4; i++) {
            employeeList.add(new Employee(nameArray[i]));
        }
        // 너무 많은 생각을 한 것 같다.
        // 일단 작성해보기.
    }
}
