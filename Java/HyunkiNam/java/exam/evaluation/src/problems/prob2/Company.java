package problems.prob2;

public class Company {
    final String name;
    final long sales;
    final int employeeCount;
    final int salaryAvg;

    public Company(String name, long sales, int employeeCount, int salaryAvg){
        this.name = name;
        this.sales = sales;
        this.employeeCount = employeeCount;
        this.salaryAvg = salaryAvg;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", sales=" + sales +
                ", employeeCount=" + employeeCount +
                ", salaryAvg=" + salaryAvg +
                '}';
    }
}
