package problems.prob21;

public class Employee {
    final String name;
    int salary;

    public Employee(String name){
        this.name = name;
        this.salary = 20000000;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
