package problems.prob1;
// 학생 정보: 나이, 이름, 전공
public class Student {
    final private String name;
    final private int age;
    final private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}
