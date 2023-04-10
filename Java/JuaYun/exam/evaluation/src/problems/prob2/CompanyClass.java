package problems.prob2;

import java.util.Scanner;

public class CompanyClass {
    final String COMPANY_NAME;
    private int SALES;
    private int EMPLOYEE_NUM;
    private int AVERAGE;

    public CompanyClass(String COMPANY_NAME, int SALES, int EMPLOYEE_NUM, int AVERAGE) {
        this.COMPANY_NAME = COMPANY_NAME;
        this.SALES = SALES;
        this.EMPLOYEE_NUM = EMPLOYEE_NUM;
        this.AVERAGE = AVERAGE;
    }

    public String getCOMPANY_NAME() {
        return COMPANY_NAME;
    }

    public int getSALES() {
        return SALES;
    }

    public int getEMPLOYEE_NUM() {
        return EMPLOYEE_NUM;
    }

    public int getAVERAGE() {
        return AVERAGE;
    }

    @Override
    public String toString() {
        return "CompanyClass{" +
                "COMPANY_NAME='" + COMPANY_NAME + '\'' +
                ", SALES=" + SALES +
                ", EMPLOYEE_NUM=" + EMPLOYEE_NUM +
                ", AVERAGE=" + AVERAGE +
                '}';
    }
}
