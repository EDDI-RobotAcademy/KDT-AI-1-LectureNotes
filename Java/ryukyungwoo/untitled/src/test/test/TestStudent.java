package test.test;

class Student {
    final private String studentName;
    final private int studentAge;
    final private String studentMajor;

    public Student(String studentName, int studentAge, String studentMajor) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentMajor = studentMajor;
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
public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student("유경우", 33, "전기공학");
        System.out.println(student);
    }
}