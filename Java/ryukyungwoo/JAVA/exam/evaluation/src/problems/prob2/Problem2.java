package problems.prob2;
class Company {
    final private String companyName;
    final private int sales;
    final private int memberNumber;
    final private int averageSalary;
    public Company (String companyName, int sales, int memberNumber, int averageSalary) {
        this.companyName = companyName;
        this.sales = sales;
        this.memberNumber = memberNumber;
        this.averageSalary = averageSalary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", sales=" + sales +
                ", memberNumber=" + memberNumber +
                ", averageSalary=" + averageSalary +
                '}';
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Company company = new Company("kh정보원", 100, 100, 10000);
        System.out.println(company);
    }
}
