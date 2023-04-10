package problems.prob2;

/*
2. 회사 클래스를 만들어봅시다. 회사는 이름, 매출, 직원 수, 평균 연봉 정보를 가지고 있습니다.
*/
class Company {
    String name;
    int sales;
    int employees;
    int salary;

    public Company(String name, int sales, int employees, int salary) {
        this.name = name;
        this.sales = sales;
        this.employees = employees;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", sales=" + sales +
                ", employees=" + employees +
                ", salary=" + salary +
                '}';
    }
}


public class Problem2 {
    public static void main(String[] args) {
        Company company1 = new Company("a회사", 11, 22, 33);
        System.out.println(company1);


    }
}
