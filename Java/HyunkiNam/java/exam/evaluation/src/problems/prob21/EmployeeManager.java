package problems.prob21;

import customLibrary.CustomRandom;
import problems.prob16.Customer;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    List<Employee> employeeList = new ArrayList<>();
    final int EMPLOYEE_NUMBER = 4;
    final int MAX_NAME_LENGTH = 5;
    public void setEmployee(){
        for(int i=0; i<EMPLOYEE_NUMBER; i++){
            String str = "";
            for(int j=0; j<MAX_NAME_LENGTH; j++){
                str += (char) CustomRandom.generateNumber('a','z');
            }
            employeeList.add(new Employee(str));
        }
    }

    public void mediateSalary(){
        final int MIN_SALARY_INCREASE = 1;
        final int MAX_SALARY_INCREASE = 50;

        for(int i=0; i<EMPLOYEE_NUMBER; i++){
            double increaseValue = CustomRandom.generateNumber(MIN_SALARY_INCREASE,MAX_SALARY_INCREASE);
            Employee currentEmployee = employeeList.get(i);
            int finalSalary = (int)(currentEmployee.getSalary() * (1 + (increaseValue/100)));
            currentEmployee.setSalary(finalSalary);
        }
    }
    public void tenYearsLaterSalary(){
        final int TEN_YEARS = 10;
        for(int i=0; i<TEN_YEARS; i++){
            mediateSalary();
        }
    }

    @Override
    public String toString() {
        return "" + employeeList;
    }
}
