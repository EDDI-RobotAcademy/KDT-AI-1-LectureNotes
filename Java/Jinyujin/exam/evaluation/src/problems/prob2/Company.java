package problems.prob2;
// 회사 정보: 이름, 매출, 직원 수, 평균 연봉
public class Company {
    final private String name;
    final private int sales;
    private int averageAnnualSalary;

    public Company(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    public void caculateSalary(int totalSalary, int numberOfEmployees) {
        averageAnnualSalary = totalSalary / numberOfEmployees; // 총연봉 % 직원 수

        System.out.println("직원 수: " + numberOfEmployees);
        System.out.println("평균 연봉: " + averageAnnualSalary);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", sales=" + sales +
                '}';
    }
}
