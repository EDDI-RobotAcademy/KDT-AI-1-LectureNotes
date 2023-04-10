package customLibrary.pb21;

import customLibrary.math.RandomGenerator;

public class Employee {
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    private int salary = 2000;
    final private float MAX_INCREASE_PERCENT = 0.5f;
    final private float MIN_INCREASE_PERCENTPOINT = 0.01f;

    public Employee(String name) {
        this.name = name;
    }

    public void increaseSalary() {
        RandomGenerator randomGenerator = new RandomGenerator();
        this.salary += salary * randomGenerator.randomFloat(MIN_INCREASE_PERCENTPOINT, MAX_INCREASE_PERCENT);
    }

}
