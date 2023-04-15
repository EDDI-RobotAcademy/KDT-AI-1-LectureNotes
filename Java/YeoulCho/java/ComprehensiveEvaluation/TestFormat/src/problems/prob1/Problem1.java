package problems.prob1;

class Person{
    String name;
    int age;
    String subject;

    public Person(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                '}';
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Person person1 =new Person("silver",25,"Math");
        Person person2 =new Person("john", 26, "English");

        System.out.println(person2);
        System.out.println(person1);

    }
}
