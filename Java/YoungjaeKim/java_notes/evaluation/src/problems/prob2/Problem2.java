package problems.prob2;

import customLibrary.Company;

public class Problem2 {
    public static void main(String[] args) {
        final String name = "company1";
        final int sales = 82613;
        final int staffCount = 5;
        final int avgSalary = 3000;

        Company company = new Company(name, sales, staffCount, avgSalary);
        System.out.println("회사 이름 : " + company.getName());
        System.out.println("회사 매출 : " + company.getSales());
        System.out.println("회사 직원 수 : " + company.getStaffCount());
        System.out.println("회사 평균 연봉 : " + company.getAvgSalary());
    }
}
