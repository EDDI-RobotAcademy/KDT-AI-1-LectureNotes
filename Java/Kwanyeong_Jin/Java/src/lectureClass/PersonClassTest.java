package lectureClass;

class Person {
    // 멤버
    final private String Name;
    public int Age;
    // 생성자
    public Person() {
        this.Name = "수강생";
        this.Age = 99;
    }
    // 매서드
    public String getName() {
        return Name;
    }
    public int getAge() {
        return Age;
    }
}
public class PersonClassTest {
    public static void main(String[] args) {
        final Person person = new Person();
        System.out.printf("나는 %s이고 나이는 %d살이다.", person.getName(),person.getAge());
    }
}
