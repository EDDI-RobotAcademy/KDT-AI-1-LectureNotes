package lectureClass;

class Person{

    private int age;
    private String name;

    public Person(int age, String name){}

    public int getAge() {
        return age = 1;
    }

    public String getName() {
        return name = "홍길동";
    }

    public void setAge (int age) {
        this.age = age;
    }
    public void setName (String name) {
        this.name = name;

}
public class PersonClass {
    public static void main(String[] args) {

        final Person person = new Person();

        System.out.println(Person.setAge(2));
        System.out.println(Person.setName("정다운"));
    }
}
