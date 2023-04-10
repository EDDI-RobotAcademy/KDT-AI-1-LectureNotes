package problems.prob21;

public class Problem21 {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        employeeManager.setEmployee();
        System.out.println(employeeManager);

        employeeManager.tenYearsLaterSalary();
        System.out.println(employeeManager);
    }
}
