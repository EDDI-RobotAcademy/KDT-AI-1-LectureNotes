package homework.fourth.student;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("학생1", 20, "연극영화과");
        student1.showInfo();
        Scanner scan = new Scanner(System.in);

        System.out.println("이름, 나이, 학과를 입력해주세요 > (enter)");
        String name = scan.nextLine();
        int age = scan.nextInt();
        scan.nextLine();
        String major = scan.nextLine();

        Student student2 = new Student(name, age, major);
        student2.showInfo();

    }
}
