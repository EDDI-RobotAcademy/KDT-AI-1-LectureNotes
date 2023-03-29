package Class_Basic_Problem;

import java.util.Scanner;

public class Student {
    private String student_Name; // 학생 이름
    private int student_Age; // 학생 나이

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public int getStudent_Age() {
        return student_Age;
    }

    public void setStudent_Age(int student_Age) {
        this.student_Age = student_Age;
    }

    public String getStudent_Major() {
        return student_Major;
    }

    public void setStudent_Major(String student_Major) {
        this.student_Major = student_Major;
    }

    private String student_Major; // 학생 전공

    public Student(String student_Name, int student_Age, String student_Major) {
        this.student_Name = student_Name;
        this.student_Age = student_Age;
        this.student_Major = student_Major;

        if (student_Name.equals("이상원")) {
            setStudent_Name("원상이");
            setStudent_Age(999);
        }
        System.out.println("학생 이름 : " + getStudent_Name() + "\n" + "학생 나이 : " + getStudent_Age() + "\n" + "학생 전공 : " + student_Major);

    }


}
