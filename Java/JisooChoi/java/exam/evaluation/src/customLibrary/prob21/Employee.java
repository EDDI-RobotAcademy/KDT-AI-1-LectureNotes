package customLibrary.prob21;

public class Employee {
    final private int initialSalary = 2000;
    private int RateOfIncrease;
    private int futureSalary;

    public Employee() {
    }

    public void saveFutureSalary(String name){
        final int MAX_SALARY = (int)(initialSalary * 0.01);
        final int MIN_SALARY = (int)(initialSalary * 0.5);
        this.RateOfIncrease = (int)(Math.random() *MAX_SALARY) +MIN_SALARY;

        final int TEN_YEARS = 10;
        this.futureSalary = this.RateOfIncrease * TEN_YEARS;
        System.out.println(name+"님의 10년 뒤 연봉은 "+ this.futureSalary+"만 원 입니다.");
    }

}
