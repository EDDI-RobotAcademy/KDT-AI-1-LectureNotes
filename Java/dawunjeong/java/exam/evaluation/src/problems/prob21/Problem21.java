package problems.prob21;

import customLibrary.RandomGenerator;

// 문제 21번
class RaiseSalary{
    private int salary = 2000;
    final private int MIN = 1;
    final private int MAX = 50;
    private int rateOfIncrease;

    public RaiseSalary() {
        this.salary = salary;
    }

    public int raiseSalary(){
        rateOfIncrease = RandomGenerator.generateNumber(MIN,MAX);
        salary = (int) (salary * (1 + (0.01 * rateOfIncrease)));
        return salary;
    }

    public int getRateOfIncrease() {
        return rateOfIncrease;
    }
}

class Employee {
    final private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int raiseYearSalary(){
        int year = 10;
        int currentSalary = 0;
        RaiseSalary raiseSalary = new RaiseSalary();
        for(int i = 0; i < year; i++){
            salary = raiseSalary.raiseSalary();
            currentSalary = salary;

        } return currentSalary;
    }

}

public class Problem21 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("정다운",2000);
        Employee employee2 = new Employee("홍길동",2000);
        Employee employee3 = new Employee("이순신",2000);
        Employee employee4 = new Employee("김유신",2000);
        System.out.println(employee1.raiseYearSalary() + "만원");
        System.out.println(employee2.raiseYearSalary() + "만원");
        System.out.println(employee3.raiseYearSalary() + "만원");
        System.out.println(employee4.raiseYearSalary() + "만원");

    }
}
