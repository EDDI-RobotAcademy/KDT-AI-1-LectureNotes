package customLibrary.prob21;

import customLibrary.utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    final int income = 20000000;
    int increaseRate;
    String employee1 = "김진호";
    String employee2 = "호날두";
    String employee3 = "메시";
    String employee4 = "손흥민";
    List<String> employeesList = new ArrayList<>();
    List<Integer> employeesIncreaseRate = new ArrayList<>();

    public Employees() {
        employeesList.add("김진호");
        employeesList.add("호날두");
        employeesList.add("메시");
        employeesList.add("손흥민");
    }



    public void randomIncreaseRate() {
        for (int i = 0; i < 10; i++) {
            increaseRate = CustomRandom.generateNumber(1, 50);
            System.out.println("연봉인상률은: " + increaseRate + "% 입니다");
            employeesIncreaseRate.add(increaseRate);
        }
    }


}
