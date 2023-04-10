package problems.prob2;

// 문제 2번
class Company{
    final String companyName;
    final int sales;
    final int employeeNum;
    final int avgSalary;

    public Company(String companyName, int sales, int employeeNum, int avgSalary) {
        this.companyName = companyName;
        this.sales = sales;
        this.employeeNum = employeeNum;
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", sales=" + sales + "원" +
                ", employeeNum=" + employeeNum + "명" +
                ", avgSalary=" + avgSalary + "원" +
                '}';
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Company company = new Company("가나다", 1000000000, 300, 35000000);
        System.out.println(company);
    }
}
