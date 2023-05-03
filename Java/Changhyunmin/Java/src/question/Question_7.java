package question;
class Lecture{
    private String LectureName = "자바";
    final private String TeacherName = "장현민";
    final private int Cost = 2500;

    @Override
    public String toString() {
        return "과목명: " + LectureName + '\n' +
                "선생님 이름: " + TeacherName + '\n' +
                "가격: " + Cost;
    }
}
public class Question_7 {
    public static void main(String[] args) {
        Lecture lecture = new Lecture();
        System.out.println(lecture);
    }
}
