package customLibrary;

public class Student {
    final int age;
    final String name;
    final String major;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public Student (int age, String name, String major) {
        this.age = age;
        this.name = name;
        this.major = major;
    }
}
