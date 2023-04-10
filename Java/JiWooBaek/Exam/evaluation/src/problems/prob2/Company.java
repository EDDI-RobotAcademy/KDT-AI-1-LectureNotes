package problems.prob2;

// 2번 문제입니다.

 class Company {

    String name;
    int sales;

    int employeeNumber;

    int averageIncome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(int averageIncome) {
        this.averageIncome = averageIncome;
    }
        public static void main(String[] args) {
        Company CompanyName = new Company();
        CompanyName.name = "삼광";

        Company CompanySales = new Company();
        CompanySales.sales = 1000000000;

        Company CompanyEmployeeNumber = new Company();
        CompanyEmployeeNumber.employeeNumber = 25;

        Company CompanyAverageIncome = new Company();
        CompanyAverageIncome.averageIncome = 25000000;

        System.out.println(CompanyName.name);
        System.out.println(CompanySales.sales);
        System.out.println(CompanyEmployeeNumber.employeeNumber);
        System.out.println(CompanyAverageIncome.averageIncome);





}
}
