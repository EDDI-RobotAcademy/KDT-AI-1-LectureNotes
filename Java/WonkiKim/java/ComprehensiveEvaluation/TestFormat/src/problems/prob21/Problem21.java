package problems.prob21;

import customLibrary.pb21.Employee;

public class Problem21 {
    public static void main(String[] args) {
        final int years = 10;


        Employee employee1 = new Employee("kim");
        Employee employee2 = new Employee("Lee");
        Employee employee3 = new Employee("Yang");

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);

        for(int i=0; i<years; i++) {
            employee1.increaseSalary();
            employee2.increaseSalary();
            employee3.increaseSalary();
        }

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
    }
}
