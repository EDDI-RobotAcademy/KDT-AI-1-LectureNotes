package homeworkTest.homework1;

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }
}



public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(26, "김진호");
        System.out.println(person1);
    }
}


