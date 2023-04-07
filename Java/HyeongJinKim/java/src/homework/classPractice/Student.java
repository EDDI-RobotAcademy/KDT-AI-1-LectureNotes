package homework.classPractice;

import java.util.Scanner;

class StudentManagement {
    final private String studentName;
    final private Scanner scan = new Scanner(System.in);
    public StudentManagement() {
        System.out.println("이름을 입력해주세요: ");
        this.studentName = scan.nextLine();
    }

    @Override
    public String toString() {
        return "StudentManagement{" +
                "studentName='" + studentName + '\'' +
                ", scan=" + scan +
                '}';
    }

}
class StudentInfo {
    StudentManagement studentManagement = new StudentManagement();

}
public class Student {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
//        StudentInfo studentInfo = studentManagement.toStudentInfo();
//        System.out.println(studentInfo);
    }
}
