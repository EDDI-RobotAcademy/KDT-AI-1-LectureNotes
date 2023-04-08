package homework.practice.studentTest;

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee = new Student("지수", 1001);
        studentLee.addSubject("국어", 100);
        studentLee.addSubject("수학", 50);
        studentLee.showStudentInfo();
    }
}
