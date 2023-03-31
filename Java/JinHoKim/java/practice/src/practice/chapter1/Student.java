package practice.chapter1;

public class Student {
    int studentId;
    String studentName;
    int grade;
    String address;

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
