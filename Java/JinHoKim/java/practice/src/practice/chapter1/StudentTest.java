package practice.chapter1;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.studentName = "김진호";
        student.address = "서울시 동작구 상도동";
        student.grade = 4;
        student.studentId = 143;;

        System.out.println(student);
    }

}
