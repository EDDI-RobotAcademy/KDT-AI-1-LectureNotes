package lectureClass;

class Person {

    final private int age;
    final private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//
//    }
}
public class PersonClass {
    public static void main(String[] args) {

        final Person person = new Person(1, "홍길동");

//        person.setAge(2);
//        person.setName("정다운");
        System.out.println("나이는 " + person.getAge() + "세, 이름은 " + person.getName() + "입니다");
    }
}
