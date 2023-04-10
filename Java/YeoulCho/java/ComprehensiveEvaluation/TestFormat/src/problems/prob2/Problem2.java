package problems.prob2;

//이름, 매출, 직원 수, 평균 연봉
class Company{
    String companyName;
    int CountEmployee;
    int employeeSalary;
    int companySales;

    public Company(String companyName, int countEmployee, int employeeSalary, int companySales) {
        this.companyName = companyName;
        this.CountEmployee = countEmployee;
        this.employeeSalary = employeeSalary;
        this.companySales = companySales;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", CountEmployee=" + CountEmployee +
                ", employeeSalary=" + employeeSalary +
                ", companySales=" + companySales +
                '}';
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Company company1 =new Company("대상",5000,1000000,3000);
        Company company2 =new Company("풀무원",4000,7000000,4000);
        System.out.println(company1);
        System.out.println(company2);

    }
}
