package lectureClass;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("MIN", 30);

        System.out.println(person1.getName() + person1.getAge());
    }
}
//작동 안됨