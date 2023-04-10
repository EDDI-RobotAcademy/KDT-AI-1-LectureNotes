package problems.prob1;

import customLibrary.Student;

public class Problem1 {
    public static void main(String[] args) {
        final int age = 26;
        final String name = "youngjaeKim";
        final String major = "computer";

        Student student = new Student(age, name, major);
        System.out.println("학생 나이 : " + student.getAge());
        System.out.println("학생 이름 : " + student.getName());
        System.out.println("학생 전공 : " + student.getMajor());
    }
}
