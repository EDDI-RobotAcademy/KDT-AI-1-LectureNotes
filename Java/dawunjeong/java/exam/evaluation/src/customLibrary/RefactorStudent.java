package customLibrary;

public class RefactorStudent {
    final int age;
    final String name;
    final String major;

    public RefactorStudent(int age, String name, String major) {
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
