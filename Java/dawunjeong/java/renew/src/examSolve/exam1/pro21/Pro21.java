package examSolve.exam1.pro21;

import examSolve.exam1.customLibrary.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Pro21 {
    public static void main(String[] args) {
        // 직원은 4명
        // 10년 후 연봉 찾기
        final int EMPLOYEE_NUMBER = 4;
        final int YEAR_NUMBER = 10;
        List<Employee> employeeList = new ArrayList<>();
        // 직원의 이름을 배열로 설정
        String[] nameArray = { "가나다", "라마바", "사아자", "차카타" };

        initEmployee(employeeList, nameArray);
        System.out.println(employeeList);

        tenYearsAfter(EMPLOYEE_NUMBER, YEAR_NUMBER, employeeList);
        System.out.println(employeeList);
    }

    // 10년 후 연봉
    // 10년 만큼, 10번 루프를 돌면서 연봉을 인상한다.
    // 1번 직원부터 4번까지 1회 연봉 인상 후
    // 다시 2회, 3회 ~ 10회까지 반복한다.
    private static void tenYearsAfter(
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

    // 직원 리스트와 이름 배열을 입력받아서
    // 직원 리스트 생성
    private static void initEmployee(List<Employee> employeeList, String[] nameArray) {
        for (int i = 0; i < 4; i++) {
            employeeList.add(new Employee(nameArray[i]));
        }
    }
}
