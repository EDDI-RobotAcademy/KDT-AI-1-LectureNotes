package problems.prob21;

import java.util.ArrayList;
import java.util.List;

// 초봉은 2000만원입니다. 직원들의 연봉 인상률은 1 ~ 50% 입니다 연봉 인상률은 랜덤으로 지정해주세요.
// 직원은 4명을 배치하고 이름은 적당히 지어줍니다. 10년 후 각자의 연봉을 출력해보도록 합시다.
public class Problem21 {
    public static void main(String[] args) {

        final int employeeNumber = 4;
        final int yearNumber = 10;

        List<Employees> employeesList = new ArrayList<>();
        String[] nameArray = {"아무개1", "아무개2", "아무개3", "아무개4"};

        initEmployee(employeesList, nameArray);
        System.out.println(employeesList);

        afterTenYears(employeeNumber, yearNumber, employeesList);
        System.out.println(employeesList);
    }

    private static void afterTenYears(int employeeNumber, int yearNumber, List<Employees> employeesList) {
        for (int i = 0; i < yearNumber; i++) {
            for (int j = 0; j < employeeNumber; j++) {
                employeesList.get(j).increaseIncome();
            }
        }
    }

    private static void initEmployee(List<Employees> employeesList, String[] nameArray) {
        for (int i = 0; i < 4; i++) {
            employeesList.add(new Employees(nameArray[i]));
        }
    }
}
