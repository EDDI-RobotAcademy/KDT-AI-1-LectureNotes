package practice.chapter3;

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100,"이순신");
        studentLee.address = "서울시 영등포구 여의도동";

        Student studentKim = new Student();
        studentKim.studentName = "김진호";
        studentKim.studentId = 101;
        studentKim.address = "서울시 동작구 상도동";

        studentLee.showStudentInfo();
        studentKim.showStudentInfo();

        System.out.println(studentKim);
        System.out.println(studentLee);
    }
}
