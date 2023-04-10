package customLibrary.pb1;

public class Student {
    final private int age;
    final private String name;
    final private String major;

    public Student(String name, String major, int age) {
        this.name = name;
        this.major = major;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }
}
