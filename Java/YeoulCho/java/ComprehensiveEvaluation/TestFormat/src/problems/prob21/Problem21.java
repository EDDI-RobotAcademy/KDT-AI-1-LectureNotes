package problems.prob21;

import customLibrary.utility.random.CustomRandom;

class CompanyJ {
    String name;
    double increaseRate;

    public CompanyJ(String name) {
        this.name = name;
    }

    public double decisionIncreaseRate() {
        increaseRate = CustomRandom.generateNumber(1, 50) * 0.01;
        return increaseRate;
    }

    public double getIncreaseRate() {
        return increaseRate;
    }

    public double afterTenYearSalary() {
        final int afterTenYears = 10;
        final double initialSalary = 2;
        double afterTenYearsSalary = initialSalary;

        for (int i = 1; i <= afterTenYears; i++) {
//            double Salary = initialSalary * decisionIncreaseRate();
            afterTenYearsSalary += initialSalary * decisionIncreaseRate();
        }
        return afterTenYearsSalary;
    }


}

public class Problem21 {
    public static void main(String[] args) {
        CompanyJ sara = new CompanyJ("sara");
        CompanyJ jaeJun = new CompanyJ("jaeJun");
        CompanyJ haeJung = new CompanyJ("haeJung");
        CompanyJ yunJin = new CompanyJ("yunJin");

        sara.afterTenYearSalary();
        jaeJun.afterTenYearSalary();
        haeJung.afterTenYearSalary();
        yunJin.afterTenYearSalary();


        System.out.println(sara.afterTenYearSalary() + "천만원");
        System.out.println(jaeJun.afterTenYearSalary() + "천만원");
        System.out.println(haeJung.afterTenYearSalary() + "천만원");
        System.out.println(yunJin.afterTenYearSalary() + "천만원");
    }
}

