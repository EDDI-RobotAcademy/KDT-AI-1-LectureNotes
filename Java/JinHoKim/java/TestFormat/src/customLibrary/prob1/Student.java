package customLibrary.prob1;

public class Student {
    final String studentName = "김진호";
    final int studentAge = 26;
    final String studentMajor = "컴공";

    public Student() {

    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", studentMajor='" + studentMajor + '\'' +
                '}';
    }
}
