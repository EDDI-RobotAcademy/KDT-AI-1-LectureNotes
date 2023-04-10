package problems.prob2;

class Company {
    final private String businessName;
    final private int sales;
    final private int employeesNumber;
    final private int salaryAverage;

    public Company() {
        this.businessName = "회사회사";
        this.sales = 1000000;
        this.employeesNumber = 3;
        this.salaryAverage = 30000000;
    }

    public String getBusinessName() {
        return businessName;
    }

    public int getSales() {
        return sales;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public int getSalaryAverage() {
        return salaryAverage;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        final Company company = new Company();

        System.out.println("회사명: " + company.getBusinessName());
        System.out.println("매출: " + company.getSales() + "원");
        System.out.println("직원 수: " + company.getEmployeesNumber() + "명");
        System.out.println("평균 연봉: " + company.getSalaryAverage() + "원");
    }
}

// 2. 회사 클래스를 만들어봅시다. 회사는 이름, 매출, 직원 수, 평균 연봉 정보를 가지고 있습니다.