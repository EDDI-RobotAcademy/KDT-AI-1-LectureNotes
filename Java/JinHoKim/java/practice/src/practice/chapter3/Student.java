package practice.chapter3;

public class Student {
    int studentId;
    String studentName;
    int grade;
    String address;

    public Student() {}

    public Student(int id, String name) {
        studentId = id;
        studentName = name;
    }

    public void showStudentInfo() {
        System.out.println(studentName + " ," + address);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", grade=" + grade +
                ", address='" + address + '\'' +
                '}';
    }
}
