package homework;

public class Person {
     String personName;
     int personAge;
     

    public static void main(String[] args) {
        Person nick = new Person();
        nick.personName ="김진호";
        System.out.println("이름: " + nick.personName);

        Person age = new Person();
        age.personAge = 26;
        System.out.println("나이: " + age.personAge);
    }
}
