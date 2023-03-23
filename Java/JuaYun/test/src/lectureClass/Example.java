package lectureClass;


class Person {
    private int age;
    private String name;

    public Person(int Age, String name) {
        this.name = name;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class Example {
    public static void main(String[] args) {
        final Person person = new Person(29,"홍길동");

        System.out.println(person.getAge());
        System.out.println(person.getName());

    }

}

