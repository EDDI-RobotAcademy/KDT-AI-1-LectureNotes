package customLibrary;

public class Company {

    final private String name;
    final private int sales;
    final private int peoples;
    final private int Salary;

    public Company(String name, int sales, int peoples, int salary) {
        this.name = name;
        this.sales = sales;
        this.peoples = peoples;
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "이름 ='" + name + '\'' +
                ", 회사 매출 =" + sales +
                ", 직원 수 =" + peoples +
                ", 연봉 =" + Salary +
                '}';
    }
}
