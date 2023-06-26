package lectureClass;

class Person {
    final private int age;  // 생성자에 있는 age와 다른 녀석입니다.
    final private String name;

    public Person(final int age, final String name) {
        // this는 Person 클래스 자기 자신임
        // (좀 더 정확히는 new로 생성된 객체 자신)
        this.age = age;
        this.name = name;
    }

    public Person() {
        age = 0;
        name = "";
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
        final Person person = new Person(3, "애기");
        final Person person2 = new Person();

        System.out.println(person);
    }
}
