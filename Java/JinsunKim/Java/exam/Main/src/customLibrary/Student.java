package customLibrary;

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
        return "Prob1_Student{" +
                "이름='" + name + '\'' +
                ", 나이=" + age +
                ", 전공='" + major + '\'' +
                '}';
    }
}
