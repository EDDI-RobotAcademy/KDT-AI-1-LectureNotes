package customLibrary;

public class Employee {
    final String name;
    final int salary = 2000;
    final int salaryIncrease;

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getSalaryIncrease() {
        return salaryIncrease;
    }

    public Employee (String name, int salaryIncrease) {
        this.name = name;
        this.salaryIncrease = salaryIncrease;
    }
}
