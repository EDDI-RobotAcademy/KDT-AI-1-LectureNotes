package problems.prob1;

public class Problem1 {
    private String name;
    private int age;
    private String major;

    public Problem1(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Problem1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}

