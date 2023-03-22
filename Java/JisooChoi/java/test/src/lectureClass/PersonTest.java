package lectureClass;

class Person{
    // 필드
    private final int age;
    private final String name;

    // 생성자
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    // 메소드
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
public class PersonTest {
    public static void main(String[] args) {
        final Person person = new Person(15, "zisoo");
        System.out.println("나이는 : "+person.getAge()+ ", 이름 : " +person.getName());

    }
}
