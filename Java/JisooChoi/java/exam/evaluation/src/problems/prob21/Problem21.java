package problems.prob21;

import customLibrary.prob21.Employee;

public class Problem21 {
    public static void main(String[] args) {
        Employee employeeLee = new Employee();
        Employee employeeSoo = new Employee();
        Employee employeeKim = new Employee();
        Employee employeePark = new Employee();

        employeeLee.saveFutureSalary("employeeLee");
        employeeSoo.saveFutureSalary("employeeSoo");
        employeeKim.saveFutureSalary("employeeKim");
        employeePark.saveFutureSalary("employeePark");
    }
}
