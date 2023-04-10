package problems.prob2;

public class Company {
    private String name;
    private int sales;
    private int employeesNum;
    private int averageSalary;

    public Company(String name, int sales, int employeesNum, int averageSalary) {
        this.name = name;
        this.sales = sales;
        this.employeesNum = employeesNum;
        this.averageSalary = averageSalary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", sales=" + sales +
                ", employeesNum=" + employeesNum +
                ", averageSalary=" + averageSalary +
                '}';
    }
}
