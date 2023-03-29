package lectureClass;

class Person {
    private Integer isAge;
    private String isName;
    public Person(Integer isAge, String isName) {
        this.isAge = isAge;
        this.isName = isName;
    }

    public int getAge () {
        return isAge;

    }
    public String getName () {
        return isName;
    }
}

public class PersonClass {
    public static void main(String[] args) {
        Person person = new Person(3, "테스트");

        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}

