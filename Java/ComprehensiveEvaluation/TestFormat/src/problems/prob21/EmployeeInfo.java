package problems.prob21;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {
    SalaryIncrease salaryIncrease = new SalaryIncrease();
    private List emploYeeList = new ArrayList<>();
    private final int employeesNum = 4;

    public EmployeeInfo() {
        for (int i = 0; i < employeesNum; i++) {
            emploYeeList.add(i +"번 직원의 10년후 연봉은 " + salaryIncrease.getFinalSalary() + "만원");
            System.out.println(emploYeeList.get(i));
        }

    }
}
