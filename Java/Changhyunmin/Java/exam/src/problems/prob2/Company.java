package problems.prob2;
class Company {
    String Name;
    int Sales;
    int Employees;
    int Salary;

    public Company(String name, int sales, int employees, int salary) {
        Name = name;
        Sales = sales;
        Employees = employees;
        Salary = salary;
    }
    void CompanyCode(){
        System.out.println("회사 이름: " + Name);
        System.out.println("매출: " +  Sales + "만원");
        System.out.println("직원 수: " + Employees + "명");
        System.out.println("평균 연봉 : " + Salary + "만원");
    }
}

