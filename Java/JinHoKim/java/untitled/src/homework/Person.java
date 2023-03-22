package homework;

public class Person {
     private String personName;
     private int personAge;

    public String getPersonName() {
        return personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public static void main(String[] args) {
        Person nick = new Person();
        nick.personName ="김진호";
        System.out.println("이름: " + nick.getPersonName());

        Person age = new Person();
        age.personAge = 26;
        System.out.println("나이: " + age.getPersonAge());
    }
}
