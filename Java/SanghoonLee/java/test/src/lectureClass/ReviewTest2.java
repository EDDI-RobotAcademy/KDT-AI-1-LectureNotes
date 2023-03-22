package lectureClass;

class Person {
    final private int age;
    final private String name;

    public Person(final int age, final String name) {
        this.age = age;
        this.name = name;
    }

    // toString()을 사용하면
    // println 에서 객체를 출력할 때 객체 정보를 출력 할 수 있습니다.
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ReviewTest2 {
    public static void main(String[] args) {
        Person person = new Person(3, "애기");

        System.out.println(person);
    }
}
