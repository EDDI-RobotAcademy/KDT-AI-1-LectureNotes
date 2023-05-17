package question;

import java.util.Scanner;

class Student {
    Scanner sc = new Scanner(System.in);
    private String Name;
    private int Age;
    private String Major;

    public Student() {
        System.out.print("이름: ");
        Name = sc.next();
        System.out.print("나이: ");
        Age = sc.nextInt();
        System.out.print("전공: ");
        Major = sc.next();
        System.out.print('\n');
    }

    @Override
    public String toString() {
        return "이름: " + Name + '\n' +
                "나이: " + Age + '\n' +
                "전공: " + Major;
    }
}
public class Question_3 {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
    }
}
