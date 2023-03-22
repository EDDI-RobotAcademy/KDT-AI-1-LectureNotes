package lectureClass;


import org.w3c.dom.ls.LSOutput;

class Person {
    String person_Name;
    int person_age;
    public Person(){}

    public Person(String person_Name) {
        this.person_Name = person_Name;
    }

    public String getPerson_Name() {
        return person_Name;
    }

    public void setPerson_Name(String person_Name) {
        this.person_Name = person_Name;
    }

    public Person(int person_age) {
        this.person_age = person_age;
    }

    public int getPerson_age() {
        return person_age;
    }

    public void setPerson_age(int person_age) {
        this.person_age = person_age;
    }
}
public class ClassTest {
    public static void main(String[] args) {
        Person person1= new Person();
        person1.person_Name = ("김");
        person1.person_age = 15;
        System.out.println("이름은: " + person1.getPerson_Name() + ", 나이는: " + person1.getPerson_age());


    }
}
