package customLibrary.prob1;

public class Student {
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
