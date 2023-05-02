package examSolve.exam1.pro1;
// 문제 1번
// 학생 클래스 : 나이, 이름, 전공

class Student{
    final private int age;
    final private String name;
    final private String major;

    public Student(int age, String name, String major) {
        this.age = age;
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
public class Pro1 {
    public static void main(String[] args) {
        Student student = new Student(32,"정다운", "화학공학과");
        System.out.println(student);
    }
}
