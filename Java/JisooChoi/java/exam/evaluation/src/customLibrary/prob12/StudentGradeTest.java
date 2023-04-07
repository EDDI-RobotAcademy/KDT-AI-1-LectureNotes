package customLibrary.prob12;

public class StudentGradeTest {
    final int studentGrade;

    public StudentGradeTest(){
        final int MAX_GRADE = 100;
        final int MINX_GRADE = 0;

        studentGrade = (int)(Math.random() * MAX_GRADE) + MINX_GRADE;
    }

    public int getStudentGrade() {
        return studentGrade;
    }
}
