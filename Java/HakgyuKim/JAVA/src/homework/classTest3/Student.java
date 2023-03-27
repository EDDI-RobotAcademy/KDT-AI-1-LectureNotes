package homework.classTest3;

public class Student {

    final private String studentName;
    final private String studentMajor;
    final private int studentAge;

    public Student(String studentName, String studentMajor, int studentAge) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.studentAge = studentAge;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
