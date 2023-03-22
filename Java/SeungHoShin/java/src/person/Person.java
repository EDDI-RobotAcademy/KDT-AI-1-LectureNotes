package person;

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
    public class PersonTest {
        public static void main(String[] args) {
            final Person person = new Person(25, "shin");
            System.out.println("나이는 : " + person.getAge() + ", 이름 : " + person.getName());
        }

}