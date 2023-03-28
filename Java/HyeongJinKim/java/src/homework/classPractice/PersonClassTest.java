package homework.classPractice;

class Person {
    private final String isName;
    private final int isAge;

    public Person() {
        this.isName = "김형진";
        this.isAge = 1;
    }

    public String getIsName() {
        return isName;
    }

    public int getIsAge() {
        return isAge;
    }
}

public class PersonClassTest {
    public static void main(String[] args) {
        final Person person = new Person();

        System.out.println("이름: " + person.getIsName());
        System.out.println("나이: " + person.getIsAge() + "세");
    }
}
