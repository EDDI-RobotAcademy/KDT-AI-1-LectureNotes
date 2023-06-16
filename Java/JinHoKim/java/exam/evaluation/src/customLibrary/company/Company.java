package customLibrary.company;

public class Company {
    private String businessName;    // 상호명
    private int costOfGoodsSold;    // 매출
    private int numberOfEmployees;  // 직원 수
    private int averageAnnualSalary;    // 평균 연봉

    public Company(String businessName, int costOfGoodsSold,
                   int numberOfEmployees, int averageAnnualSalary) {

        this.businessName = businessName;
        this.costOfGoodsSold = costOfGoodsSold;
        this.numberOfEmployees = numberOfEmployees;
        this.averageAnnualSalary = averageAnnualSalary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "businessName='" + businessName + '\'' +
                ", costOfGoodsSold=" + costOfGoodsSold +
                ", numberOfEmployees=" + numberOfEmployees +
                ", averageAnnualSalary=" + averageAnnualSalary +
                '}';
    }
}
