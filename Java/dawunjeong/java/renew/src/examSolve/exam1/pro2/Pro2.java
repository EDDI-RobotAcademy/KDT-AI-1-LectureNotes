package examSolve.exam1.pro2;
// 문제 2번
// 회사 클래스 : 이름, 매출, 직원 수, 평균 연봉

class Company{
    String companyName;
    int sales;
    int employeeNum;
    int avgSalary;

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
                ", sales=" + sales + "억원" +
                ", employeeNum=" + employeeNum +  "명" +
                ", salary=" + avgSalary +  "만원" +
                '}';
    }
}
public class Pro2 {
    public static void main(String[] args) {
        Company company = new Company("가나다", 3000,300,3000);
        System.out.println(company);
    }
}
