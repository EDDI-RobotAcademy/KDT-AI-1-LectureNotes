package lectureClass;

import org.w3c.dom.ls.LSOutput;

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class PersonTest {
    public static void main(String[] args) {
        final Person PERSON1 = new Person(20, "홍길동");
        System.out.println("이름은: " + PERSON1.getName() + ", 나이는: " + PERSON1.getAge());
    }
}
