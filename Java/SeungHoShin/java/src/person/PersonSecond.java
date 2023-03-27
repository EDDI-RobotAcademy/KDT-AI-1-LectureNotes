package person;
class Person{
    final int age;
    final String name;

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
}

public class PersonSecond {
    public static void main(String[] args) {
        final Person person= new Person(15,"SHIN");
        System.out.println("나이는:"+person.getAge()+"이름은:"+person.getName());

    }

}
