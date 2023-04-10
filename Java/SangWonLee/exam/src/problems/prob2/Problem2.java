package problems.prob2;


import java.text.DecimalFormat;

public class Problem2 {
    public static void main(String[] args) {

        Company company = new Company("김대완",3000000000l,13,24000000);

        System.out.println(company.employeeName);
        System.out.println(company.companyMoney);
        System.out.println(company.employeeNumber);
        System.out.println(company.employeeAverageMoney);


    }
}
